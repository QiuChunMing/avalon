package com.example.avalon.service;

import com.example.AvalonApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AvalonApplication.class)
@Slf4j
public class AddressSuggestConfigurationServiceTest {

    @Autowired
    private CitiesService citiesService;


    @Test
    public void guessAdress() {
        ServiceResult result = citiesService.cityGuess(null);
        log.info("guessAdress:{}", result.getResult());
    }
}