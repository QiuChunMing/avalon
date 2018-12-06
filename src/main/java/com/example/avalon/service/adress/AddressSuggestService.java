package com.example.avalon.service.adress;

import com.example.avalon.base.AddressSuggestConfiguration;
import com.example.avalon.base.response.GuessPositionResponse;
import com.example.avalon.service.ServiceResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class AddressSuggestService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AddressSuggestConfiguration addressSuggestConfiguration;

    @Autowired
    private ObjectMapper objectMapper;

    public ServiceResult<GuessPositionResponse> guessAdress(String ip) {
        String searchIp = Optional.ofNullable(ip).orElse("180.158.102.141");
        ResponseEntity<String> responseEntity;
        for (String s : addressSuggestConfiguration.getTencentkeys()) {
            Map<String, String> queryParam = new HashMap<>();
            queryParam.put("key", s);
            queryParam.put("ip", searchIp);
            responseEntity = restTemplate.getForEntity(addressSuggestConfiguration.getGuessPositionUrl()+"?ip={ip}&key={key}", String.class, queryParam);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                try {
                    GuessPositionResponse addressResult = objectMapper.readValue(responseEntity.getBody(), GuessPositionResponse.class);
                    log.debug("addressResult is:{}",addressResult);
                    return ServiceResult.of(addressResult);
                } catch (IOException e) {
                    ServiceResult.fail();
                }
            }
        }
        return ServiceResult.fail();
    }
}
