package com.example.avalon.web.admin.controller;

import com.example.AvalonApplication;
import com.example.avalon.entity.Cities;
import com.example.avalon.repository.CitiesRepository;
import com.example.avalon.dto.CitiesDTO;
import com.example.avalon.dto.PoisHashDTO;
import com.example.avalon.dto.PoisDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AvalonApplication.class)
public class CitiesControllerTest {

    @Autowired
    private CitiesController citiesController;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("classpath:Cities.json")
    Resource resource;

    @Autowired
    private CitiesRepository repository;

    private Map<String, List<Cities>> map = new HashMap<>();

    @Test
    public void cities() {
        CitiesDTO cities = citiesController.cities("guess");
        log.debug("城市推测：{}", cities.toString());
    }

    @Test
    public void initCities() {
        try {
            JsonNode root = objectMapper.readTree(resource.getInputStream());
            Iterator<Map.Entry<String, JsonNode>> fields = root.fields();

            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> next = fields.next();
                String key = next.getKey();
                List<Cities> cities = objectMapper.readValue(next.getValue().toString(), new TypeReference<List<Cities>>() {
                });
                map.put(key, cities);
                log.debug("key is {}", key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, List<Cities>> entry : map.entrySet()) {
            List<Cities> cities = entry.getValue();
            if ("hotCities".equals(entry.getKey())) {
                for (Cities city : cities) {
                    log.debug("city name {}",city.getName());
                    Cities byName = repository.findFirstByName(city.getName());
                    log.debug("city name {}",byName==null);
                    if (byName != null) {
                        byName.setHotCity(true);
                        byName.setName("修改后"+byName.getName());
                        repository.save(byName);
                    }
                }
            } else {
                for (Cities city : cities) {
                    repository.save(city);
                }
            }


        }

    }

    @Test
    public void citiesById() {
        CitiesDTO citiesDTO = citiesController.citiesById(553);
        log.debug("533 city info is:{}", citiesDTO);
    }

    @Test
    public void pois() {
        List<PoisDTO> pois = citiesController.pois(4, "麦当劳", "");
        try {
            log.debug("{}",objectMapper.writeValueAsString(pois));
        } catch (JsonProcessingException e) {

        }
    }

    @Test
    public void poishash() {
        PoisHashDTO poishash = citiesController.poishash("31.22967,121.4762");
        PoisHashDTO poishash1 = citiesController.poishash("31.22967121,5566.4762");
        try {
            log.debug("{}", objectMapper.writeValueAsString(poishash));
            log.debug("{}", objectMapper.writeValueAsString(poishash1));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}