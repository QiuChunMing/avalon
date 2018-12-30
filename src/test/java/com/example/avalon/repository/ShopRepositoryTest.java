package com.example.avalon.repository;

import com.example.avalon.AvalonApplicationTests;
import com.example.avalon.entity.shop.Shop;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class ShopRepositoryTest extends AvalonApplicationTests {
    @Autowired
    private ShopRepository shopRepository;

    @Test
    public void findByName() {
    }

    @Test
    public void findAll() {
        List<Shop> all = shopRepository.findAll();
        for (Shop shop : all) {
            log.debug(shop.toString());
        }
    }


}