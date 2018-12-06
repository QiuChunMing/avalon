package com.example.avalon.base.impl;

import com.example.avalon.base.AddressSearch;
import com.example.avalon.base.AddressSuggestConfiguration;
import com.example.avalon.base.response.SearchPlaceResponse;
import com.example.avalon.base.response.GeocoderResponse;
import com.example.avalon.base.response.GetDistanceResponse;
import com.example.avalon.base.response.GuessPositionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class AddressCompnent implements AddressSearch {
    @Autowired
    private AddressSuggestConfiguration configuration;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public GuessPositionResponse guessPosition(String ip) {
        String searchIp = Optional.ofNullable(ip).orElse("180.158.102.141");
        ResponseEntity<String> responseEntity;
        for (String s : configuration.getTencentkeys()) {
            Map<String, String> queryParam = new HashMap<>();
            queryParam.put("key", s);
            queryParam.put("ip", searchIp);
            try {
                responseEntity = restTemplate.getForEntity(configuration.getGuessPositionUrl() + "?ip={ip}&key={key}", String.class, queryParam);
                log.debug(responseEntity.getBody());
            } catch (RestClientException e) {
                log.error("{}访问异常：", configuration.getGuessPositionUrl());
                return null;
            }
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                GuessPositionResponse guessPositionResponse = null;
                try {
                    guessPositionResponse = objectMapper.readValue(responseEntity.getBody(), GuessPositionResponse.class);
                    log.error("guessPositionResponse is:{}", guessPositionResponse);
                    //if the key wrong,try the next
                    if (guessPositionResponse.getMessage().contains("key")) {
                        continue;
                    }
                    return guessPositionResponse;
                } catch (IOException e) {
                    log.error("数据转换异常：{}", guessPositionResponse);
                }
            }
        }
        return null;
    }

    @Override
    public SearchPlaceResponse searchPlace(String keyword, String cityName) {

        for (String tencentKey : configuration.getTencentkeys()) {
            Map<String, String> requestParam = new HashMap<>();
            requestParam.put("key", tencentKey);
            requestParam.put("keyword", keyword);
            requestParam.put("boundary", "region(" + cityName + ",0)");
            requestParam.put("page_size", "10");
            ResponseEntity<String> responseEntity = null;
            try {
                responseEntity = restTemplate.getForEntity(configuration.getSearchPlaceUrl() + "?key={key}&keyword={keyword}&boundary={boundary}&page_size={page_size}", String.class, requestParam);
                log.debug(responseEntity.getBody());
            } catch (RestClientException e) {
                log.error("{}访问异常：", configuration.getSearchPlaceUrl());
            }
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                SearchPlaceResponse searchPlaceResponse;
                try {
                    searchPlaceResponse = objectMapper.readValue(responseEntity.getBody(), SearchPlaceResponse.class);
                    if (searchPlaceResponse.getMessage().contains("key")) {
                        continue;
                    }
                    return searchPlaceResponse;
                } catch (IOException e) {
                    log.error("数据转换异常：{}", responseEntity.getBody());
                }
            }


        }
        return null;
    }

    @Override
    public GetDistanceResponse getDistance(String from, String to) {
        Map requestParam = new HashMap();

        log.info("baiduKey is:{}", configuration.getBaiduKeys());
        log.info("searchPlaceUrl is:{}", configuration.getGetDistanceUrl());
        for (String baiduKey : configuration.getBaiduKeys()) {
            requestParam.put("ak", baiduKey);
            requestParam.put("output", "json");
            requestParam.put("origins", from);
            requestParam.put("destinations", to);

            ResponseEntity<String> responseEntity = null;
            try {
                responseEntity = restTemplate.getForEntity(configuration.getGetDistanceUrl() + "?ak={ak}&output={output}&origins={origins}&destinations={destinations}", String.class, requestParam);
                log.debug(responseEntity.getBody());
            } catch (RestClientException e) {
                log.error("{}访问异常：", configuration.getGetDistanceUrl());
                return null;
            }
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                GetDistanceResponse distanceResponse = null;
                try {
                    distanceResponse = objectMapper.readValue(responseEntity.getBody(), GetDistanceResponse.class);
                    if (distanceResponse.getMessage().contains("ak")) {
                        continue;
                    }
                } catch (IOException e) {
                    log.error("数据转换异常：{}", e.getMessage());
                    e.printStackTrace();
                }
                return distanceResponse;
            }
        }
        return null;
    }

    /**
     * 根据ip查询详细地址
     *
     * @param ip
     * @return
     */
    @Override
    public GeocoderResponse geocoder(String ip) {
        GuessPositionResponse positionResponse = this.guessPosition(ip);
        GuessPositionResponse.ResultBean.LocationBean location = positionResponse.getResult().getLocation();
        return getpois(String.valueOf(location.getLat()), String.valueOf(location.getLng()));
    }

    @Override
    public GeocoderResponse getpois(String lat, String lng) {
        for (String tencentKey : configuration.getTencentkeys()) {
            HashMap<String, String> requestParam = new HashMap<>();
            requestParam.put("key", tencentKey);
            requestParam.put("location", lat + "," + lng);

            ResponseEntity<String> responseEntity = null;
            try {
                responseEntity = restTemplate.getForEntity(configuration.getGeocoderUrl() + "?key={key}&location={location}", String.class, requestParam);
                log.debug(responseEntity.getBody());
            } catch (RestClientException e) {
                log.error("{}访问异常：", configuration.getGeocoderUrl());
                return null;
            }
            GeocoderResponse response = null;
            try {
                response = objectMapper.readValue(responseEntity.getBody(), GeocoderResponse.class);
                if (response.getMessage().contains("key")) {
                    continue;
                }
                return response;
            } catch (IOException e) {
                log.error("数据转换异常：{}", response);
            }
        }
        return null;
    }
}
