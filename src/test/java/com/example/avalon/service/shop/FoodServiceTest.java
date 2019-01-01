package com.example.avalon.service.shop;

import com.example.avalon.AvalonApplicationTests;
import com.example.avalon.entity.food.FoodAttribute;
import com.example.avalon.repository.FoodAttributeRepository;
import com.example.avalon.service.ServiceResult;
import com.example.avalon.web.form.AddFoodForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
@Slf4j
public class FoodServiceTest extends AvalonApplicationTests {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodAttributeRepository foodAttributeRepository;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void addFood() {
        String addFood = "{\n" +
                "    \"name\":\"xvxv\",\n" +
                "    \"description\":\"vx\",\n" +
                "    \"image_path\":\"167ff2fb5e97.png\",\n" +
                "    \"activity\":\"xvx\",\n" +
                "    \"attributes\":[\n" +
                "        \"新\",\n" +
                "        \"招牌\"\n" +
                "    ],\n" +
                "    \"specs\":[\n" +
                "        {\n" +
                "            \"specs\":\"默认\",\n" +
                "            \"packing_fee\":0,\n" +
                "            \"price\":20\n" +
                "        }\n" +
                "    ],\n" +
                "    \"restaurant_id\":1\n" +
                "}";
        AddFoodForm result = null;
        try {
            result = objectMapper.readValue(addFood, AddFoodForm.class);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        ServiceResult result1 = foodService.addFood(result);
        log.debug("操作结果:{}",result1.isSuccess());
    }

    @Test
    public void repository() {
        foodAttributeRepository.save(new FoodAttribute("好吃"));
    }
}