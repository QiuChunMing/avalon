package com.example.avalon.service;

import com.example.AvalonApplication;
import com.example.avalon.AvalonApplicationTests;
import com.example.avalon.entity.Cities;
import com.example.avalon.repository.CitiesRepository;
import com.example.avalon.service.address.CitiesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@Slf4j

public class CitiesServiceTest extends AvalonApplicationTests {

    @Autowired
    private CitiesRepository citiesRepository;

    @Value("classpath:Cities.json")
    private Resource resource;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CitiesService citiesService;

    @Test
    public void guessCities() {
        List<Cities> readValue = null;
        try {
            readValue = objectMapper.readValue(resource.getInputStream()
                    , new TypeReference<List<Cities>>() {
                    });

        } catch (IOException e) {
            log.error("{}转换成对象失败", resource.getFilename());
        }
        if (readValue != null) {
            for (Cities cities : readValue) {
                citiesRepository.save(cities);
            }
        }


    }

    @Test
    public void cityHot() {
        ServiceResult<List<Cities>> listServiceResult = citiesService.cityHot();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(listServiceResult.getResult());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.debug(s);
    }
}