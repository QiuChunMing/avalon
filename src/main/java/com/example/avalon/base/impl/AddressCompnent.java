package com.example.avalon.base.impl;

import com.example.avalon.base.AddressSearch;
import com.example.avalon.base.AddressSuggestConfiguration;
import com.example.avalon.base.response.GeocoderResponse;
import com.example.avalon.base.response.GetDistanceResponse;
import com.example.avalon.base.response.GuessPositionResponse;
import com.example.avalon.base.response.SearchPlaceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.kerberos.KerberosKey;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
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

    private String defaultIP = "120.85.181.250";

    @Override
    public GuessPositionResponse guessPosition(String ip) {
        String searchIp = Optional.ofNullable(ip).orElse(defaultIP);
        log.debug("searchIP is:{}",searchIp);
        ResponseEntity<String> responseEntity;
        for (String s : configuration.getTencentkeys()) {
            Map<String, String> queryParam = new HashMap<>();
            queryParam.put("key", s);
            queryParam.put("ip", searchIp);
            try {
                responseEntity = restTemplate.getForEntity(configuration.getGuessPositionUrl()
                        + "?ip={ip}&key={key}", String.class, queryParam);
                log.debug(responseEntity.getBody());
            } catch (RestClientException e) {
                log.error("{}访问异常：", configuration.getGuessPositionUrl());
                return null;
            }
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                GuessPositionResponse guessPositionResponse = null;
                try {
                    guessPositionResponse = objectMapper.readValue(responseEntity.getBody(), GuessPositionResponse.class);
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
        if (keyword.length() > 64 && keyword.length() < 1) {
            return null;
        }

        for (String tencentKey : configuration.getTencentkeys()) {
            Map<String, String> requestParam = new HashMap<>();


            try {
                requestParam.put("key", tencentKey);
                requestParam.put("keyword", URLEncoder.encode(keyword,"UTF-8"));
                requestParam.put("boundary", "region(" + URLEncoder.encode(cityName,"UTF-8") + ",0)");
                requestParam.put("page_size", "10");
            } catch (UnsupportedEncodingException e) {
                log.error("encode error:{} ",e.getCause());
            }

            ResponseEntity<String> responseEntity = null;
            try {
                responseEntity = restTemplate.getForEntity(configuration.getSearchPlaceUrl()
                        + "?key={key}&keyword={keyword}&boundary={boundary}&page_size={page_size}", String.class, requestParam);
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
                responseEntity = restTemplate.getForEntity(configuration.getGetDistanceUrl()
                        + "?ak={ak}&output={output}&origins={origins}&destinations={destinations}", String.class, requestParam);
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
        Assert.notNull(ip,"ip 不为空");

        GuessPositionResponse positionResponse = this.guessPosition(ip);
        log.debug("positionResponse is {}:", positionResponse);

        if (positionResponse == null) {
            log.error("geocoder 查询异常");
        }

        if (positionResponse.getStatus() != 0) {
            log.error("ip:{} 无法定位,错误信息:{}",ip,positionResponse);
            return null;
        }
        Optional<GuessPositionResponse.ResultBean.LocationBean> locationBean
                = Optional.ofNullable(positionResponse)
                .map(r -> r.getResult()).map(r->r.getLocation());


        return getpois(String.valueOf(locationBean.map(b -> b.getLat()))
                , String.valueOf(locationBean.map(b -> b.getLng())));
    }

    /**
     * 根据经纬度查询位置
     * @param lat
     * @param lng
     * @return
     */
    @Override
    public GeocoderResponse getpois(String lat, String lng) {
        Assert.notNull(lat,"lat 不为空");
        Assert.notNull(lng,"lng 不为空");

        for (String tencentKey : configuration.getTencentkeys()) {
            HashMap<String, String> requestParam = new HashMap<>();
            requestParam.put("key", tencentKey);
            requestParam.put("location", lat + "," + lng);

            ResponseEntity<String> responseEntity;
            try {
                responseEntity = restTemplate.getForEntity(configuration.getGeocoderUrl()
                                + "?key={key}&location={location}"
                        , String.class, requestParam);
                log.debug(responseEntity.getBody());
            } catch (RestClientException e) {
                log.error("{}访问异常：", configuration.getGeocoderUrl());
                return null;
            }
            GeocoderResponse response = null;
            try {
                response = objectMapper.readValue(responseEntity.getBody(), GeocoderResponse.class);
                if (response.getMessage().contains("key")) {
                    log.error("key 失效 {}",response.getMessage());
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
