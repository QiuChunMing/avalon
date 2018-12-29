package com.example.avalon.service;

import com.example.AvalonApplication;
import com.example.avalon.AvalonApplicationTests;
import com.example.avalon.entity.Category;
import com.example.avalon.repository.CategoryRepository;
import com.example.avalon.dto.CategoryDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
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
public class CategoryServiceTest extends AvalonApplicationTests {

    @Value("classpath:Categories.json")
    Resource resource;


    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getCategories() {

        ServiceResult<List<CategoryDTO>> categories = categoryService.getCategories();
        try {
            String s = objectMapper.writeValueAsString(categories.getResult());
            log.debug("商品种类 json :{}", s);
        } catch (JsonProcessingException e) {
            log.error("{}", e.getMessage());
        }
    }

    @Test
    public void getTheCategoryData() {


        try {
            log.debug("path is {} :", resource);
            List<Category> readValue = objectMapper.readValue(resource.getInputStream()
                    , new TypeReference<List<Category>>() {
                    });
            log.debug("size is {}:", readValue.size());
            for (Category category : readValue) {
                category.setParentId(0);
                Category save = repository.save(category);
                log.debug("save sucess :{}", save.getId());
                if (category.getCategory() != null && category.getCategory().size() > 0) {
                    for (Category category1 : category.getCategory()) {
                        category1.setParentId(category.getId());
                        if (category1.getId()!=category1.getParentId()) {
                            repository.save(category1);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addCategory() {
        Assert.assertTrue((categoryService.addCategory("甜品饮品/奶茶果汁")).isSuccess());
        Assert.assertTrue((categoryService.addCategory("甜品饮品/甜品饮品")).isSuccess());
        Assert.assertFalse((categoryService.addCategory("甜品饮品/东南亚菜")).isSuccess());
    }
}