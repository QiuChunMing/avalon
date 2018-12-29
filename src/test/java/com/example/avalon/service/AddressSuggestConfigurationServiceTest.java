package com.example.avalon.service;

import com.example.AvalonApplication;
import com.example.avalon.AvalonApplicationTests;
import com.example.avalon.service.address.CitiesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
public class AddressSuggestConfigurationServiceTest extends AvalonApplicationTests {

    @Autowired
    private CitiesService citiesService;


    @Test
    public void guessAdress() {
        ServiceResult result = citiesService.cityGuess(null);
        log.info("guessAdress:{}", result.getResult());
    }
}