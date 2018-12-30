package com.example.avalon.service.shop;

import com.example.avalon.AvalonApplicationTests;
import com.example.avalon.entity.shop.Activities;
import com.example.avalon.entity.shop.Shop;
import com.example.avalon.service.ServiceResult;
import com.example.avalon.web.form.AddShopForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class ShopServiceTest extends AvalonApplicationTests {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void addShop() {
        String json = "{\n" +
                "    \"name\":\"xiao\",\n" +
                "    \"address\":\"上海市宝山区上大路99号\",\n" +
                "    \"latitude\":31.31601,\n" +
                "    \"longitude\":121.393402,\n" +
                "    \"description\":\"\",\n" +
                "    \"phone\":155,\n" +
                "    \"promotion_info\":\"\",\n" +
                "    \"float_delivery_fee\":5,\n" +
                "    \"float_minimum_order_amount\":20,\n" +
                "    \"is_premium\":true,\n" +
                "    \"delivery_mode\":true,\n" +
                "    \"new\":true,\n" +
                "    \"bao\":true,\n" +
                "    \"zhun\":true,\n" +
                "    \"piao\":true,\n" +
                "    \"startTime\":\"05:45\",\n" +
                "    \"endTime\":\"06:00\",\n" +
                "    \"image_path\":\"167ff1691b91.png\",\n" +
                "    \"business_license_image\":\"167ff1695322.png\",\n" +
                "    \"catering_service_license_image\":\"167ff16ba1d3.png\",\n" +
                "    \"activities\":[\n" +
                "        {\n" +
                "            \"icon_name\":\"减\",\n" +
                "            \"name\":\"满减优惠\",\n" +
                "            \"description\":\"满30减5，满60减8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"icon_name\":\"新\",\n" +
                "            \"name\":\"新用户立减\",\n" +
                "            \"description\":\"郭德纲\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"category\":\"快餐便当\"\n" +
                "}";
        AddShopForm addShopForm = null;
        try {
            addShopForm = objectMapper.readValue(json, AddShopForm.class);
        } catch (IOException e) {
            log.error("Json:{} can not convert to class:{}", json, Activities.class);
        }
        ServiceResult<Shop> shopServiceResult = shopService.addShop(addShopForm);
        log.debug(shopServiceResult.getResult().getActivities().toString());
    }
}