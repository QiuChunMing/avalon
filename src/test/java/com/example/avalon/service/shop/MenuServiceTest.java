package com.example.avalon.service.shop;

import com.example.avalon.AvalonApplicationTests;
import com.example.avalon.entity.food.Menu;
import com.example.avalon.service.ServiceResult;
import com.example.avalon.web.form.AddMenuForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@Slf4j
public class MenuServiceTest extends AvalonApplicationTests {

    @Autowired
    private MenuService menuService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void addMenu() {
        String json = "{\n" +
                "    \"name\":\"dfs\",\n" +
                "    \"description\":\"fs\",\n" +
                "    \"restaurant_id\":1\n" +
                "}";
        AddMenuForm menuForm = null;
        try {
            menuForm = objectMapper.readValue(json, AddMenuForm.class);
            menuForm.setRestaurant_id(1);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        ServiceResult<Menu> menuServiceResult = menuService.addMenu(menuForm);
        try {
            log.debug("{},{}", menuServiceResult.getMessage()
                    , objectMapper.writeValueAsString(menuServiceResult.getResult()));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }

    }

    @Test
    public void getMenus() {
        ServiceResult<List<Menu>> menus = menuService.getAllMenus();
        try {
            log.debug(objectMapper.writeValueAsString(menus));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}