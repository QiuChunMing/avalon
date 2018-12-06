package com.example.avalon.service;

import com.example.AvalonApplication;
import com.example.avalon.entity.Category;
import com.example.avalon.repository.CategoryRepository;
import com.example.avalon.web.vo.CategoryVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AvalonApplication.class)
@Slf4j
public class CategoryServiceTest {
    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getCategories() {
        ServiceResult<List<CategoryVO>> categories = categoryService.getCategories();
        List<CategoryVO> result = categories.getResult();
        try {
            String s = objectMapper.writeValueAsString(result);
            log.debug("商品种类 json :{}",s);
        } catch (JsonProcessingException e) {
            log.error("{}",e.getMessage());
        }
    }
}