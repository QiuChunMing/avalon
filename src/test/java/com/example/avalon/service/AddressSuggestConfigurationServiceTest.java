package com.example.avalon.service;

import com.example.AvalonApplication;
import com.example.avalon.service.adress.AddressSuggestService;
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
    private AddressSuggestService addressSuggestService;


    @Test
    public void guessAdress() {
        ServiceResult result = addressSuggestService.guessAdress(null);
        log.info("guessAdress:{}", result.getResult());
    }
}