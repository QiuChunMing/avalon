package com.example.avalon.service.address;

import com.example.avalon.service.address.response.GeocoderResponse;
import com.example.avalon.service.address.response.GetDistanceResponse;
import com.example.avalon.service.address.response.GuessPositionResponse;
import com.example.avalon.service.address.response.SearchPlaceResponse;
import com.example.avalon.service.ServiceResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

@Slf4j
@Component
public class IAddressServiceServiceImp implements IAddressService {
    @Autowired
    private AddressSuggestConfiguration configuration;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private String defaultIP = "120.85.181.250";

    @Override
    public ServiceResult<GuessPositionResponse> guessPosition(String ip) {
        String searchIp = Optional.ofNullable(ip).orElse(defaultIP);
        log.debug("searchIP is:{}",searchIp);
        ResponseEntity<String> responseEntity;
        for (String tencentKey : configuration.getTencentkeys()) {

            StringBuilder builder = new StringBuilder();
            builder.append(configuration.getGuessPositionUrl()).append("?")
                    .append("key=").append(tencentKey).append("&")
                    .append("ip=").append(searchIp);

            try {
                responseEntity = restTemplate.getForEntity(builder.toString(), String.class);
                log.debug(responseEntity.getBody());
            } catch (RestClientException e) {
                log.error("{} can not be fetch:{}", configuration.getGuessPositionUrl(),e.getMessage());
                return new ServiceResult<>(false,e.getMessage());
            }
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                GuessPositionResponse guessPositionResponse;
                try {
                    guessPositionResponse = objectMapper.readValue(responseEntity.getBody(), GuessPositionResponse.class);
                    //if the key wrong,try the next
                    if (guessPositionResponse.getMessage().contains("key")) {
                        continue;
                    }
                    return ServiceResult.of(guessPositionResponse);
                } catch (IOException e) {
                    log.error("objectMapper convert error: key :{}", tencentKey);
                }
            }
        }
        return new ServiceResult<>(false, "httpStatusCode isNot2xxSuccessful");
    }

    @Override
    public ServiceResult<SearchPlaceResponse> searchPlace(String keyword, String cityName) {
        if (keyword.length() > 64 || keyword.length() < 1) {
            return new ServiceResult<>(false,"cityName or keyword is not valid");
        }

        for (String tencentKey : configuration.getTencentkeys()) {
            String url;

            try {
                StringBuilder builder = new StringBuilder();
                builder.append(configuration.getSearchPlaceUrl()).append("?")
                        .append("key=").append(tencentKey).append("&")
                        .append("boundary=").append("region(" + URLEncoder.encode(cityName, "UTF-8") + ",0)").append("&")
                        .append("keyword=").append(URLEncoder.encode(keyword, "UTF-8")).append("&")
                        .append("page_size=").append("10");
                url = builder.toString();
            } catch (UnsupportedEncodingException e) {
                log.error("encode error:{} ",e.getCause());
                return new ServiceResult<>(false, e.getMessage());
            }

            ResponseEntity<String> responseEntity;
            try {
                responseEntity = restTemplate.getForEntity(url, String.class);
                log.debug(responseEntity.getBody());
            } catch (RestClientException e) {
                log.error("{} can not be fetched:", configuration.getSearchPlaceUrl());
                return new ServiceResult<>(false, e.getMessage());
            }
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                SearchPlaceResponse searchPlaceResponse;
                try {
                    searchPlaceResponse = objectMapper.readValue(responseEntity.getBody(), SearchPlaceResponse.class);
                    if (searchPlaceResponse.getMessage().contains("key")) {
                        log.warn("key {} ",tencentKey);
                        continue;
                    }
                    return ServiceResult.of(searchPlaceResponse);
                } catch (IOException e) {
                    log.error("objectMapper read value error:{}", responseEntity.getBody());
                    return new ServiceResult<>(false, e.getMessage());
                }
            }
        }
        return new ServiceResult<>(false, "httpStatusCode isNot2xxSuccessful");
    }

    @Override
    public ServiceResult<GetDistanceResponse> getDistance(String from, String to) {

        log.info("baiduKey is:{}", configuration.getBaiduKeys());
        log.info("searchPlaceUrl is:{}", configuration.getGetDistanceUrl());
        for (String baiduKey : configuration.getBaiduKeys()) {

            StringBuilder builder = new StringBuilder();
            builder.append(configuration.getGetDistanceUrl()).append("?")
                    .append("ak=").append(baiduKey).append("&")
                    .append("output=").append("json").append("&")
                    .append("origins=").append(from)
                    .append("destinations=").append(to);
            ResponseEntity<String> responseEntity;
            try {
                responseEntity = restTemplate.getForEntity(builder.toString(), String.class);
            } catch (RestClientException e) {
                log.error("{} can not be fetched:", configuration.getGetDistanceUrl());
                return new ServiceResult<>(false,e.getMessage());
            }
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                GetDistanceResponse distanceResponse = null;
                try {
                    distanceResponse = objectMapper.readValue(responseEntity.getBody(), GetDistanceResponse.class);
                    if (distanceResponse.getMessage().contains("ak")) {
                        continue;
                    }
                } catch (IOException e) {
                    log.error("objectMapper convert error:{}", e.getMessage());
                    e.printStackTrace();
                }
                return ServiceResult.of(distanceResponse);
            }
        }
        return new ServiceResult<>(false, "httpStatusCode isNot2xxSuccessful");
    }

    /**
     * 根据ip查询详细地址
     *
     * @param ip
     * @return
     */
    @Override
    public ServiceResult<GeocoderResponse> geocoder(String ip) {

        double lat;
        double lng;

        ServiceResult<GuessPositionResponse> positionResponseServiceResult = this.guessPosition(ip);

        if (!positionResponseServiceResult.isSuccess()) {
            return new ServiceResult<>(false, positionResponseServiceResult.getMessage());
        }

        GuessPositionResponse positionResponseServiceResultResult = positionResponseServiceResult.getResult();
        if (positionResponseServiceResultResult.getStatus() != 0) {
            log.warn("ip:{} 无法定位 :{}",ip,positionResponseServiceResultResult.getMessage());
            return new ServiceResult<>(false,"");
        }
        lat = positionResponseServiceResultResult.getResult().getLocation().getLat();
        lng = positionResponseServiceResultResult.getResult().getLocation().getLng();

        return getpois(String.valueOf(lat), String.valueOf(lng));
    }

    /**
     * 根据经纬度查询位置
     * @param lat
     * @param lng
     * @return
     */
    @Override
    public ServiceResult<GeocoderResponse> getpois(String lat, String lng) {

        for (String tencentKey : configuration.getTencentkeys()) {

            StringBuilder builder = new StringBuilder();
            builder.append(configuration.getGeocoderUrl()).append("?")
                    .append("key=").append(tencentKey).append("&")
                    .append("location=").append(lat).append(",").append(lng);

            ResponseEntity<String> responseEntity;
            try {
                responseEntity = restTemplate.getForEntity(builder.toString()
                        , String.class);
                log.debug(responseEntity.getBody());
            } catch (RestClientException e) {
                log.warn("{} can not be fetched::", configuration.getGeocoderUrl());
                return new ServiceResult<>(false,e.getMessage());
            }
            GeocoderResponse response;
            try {
                response = objectMapper.readValue(responseEntity.getBody(), GeocoderResponse.class);
                if (response.getMessage().contains("key")) {
                    log.warn("key 失效 {}",response.getMessage());
                    continue;
                }
                return ServiceResult.of(response);
            } catch (IOException e) {
                log.error("getpois objectMapper convert error");
            }
        }
        return new ServiceResult<>(false,"httpStatusCode isNot2xxSuccessful");
    }
}
