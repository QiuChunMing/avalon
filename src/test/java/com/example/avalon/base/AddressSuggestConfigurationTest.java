package com.example.avalon.base;

import com.example.AvalonApplication;
import com.example.avalon.service.address.AddressSuggestConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AvalonApplication.class)
@Slf4j
public class AddressSuggestConfigurationTest {

    @Autowired
    private AddressSuggestConfiguration addressSuggestConfiguration;



    @Test
    public void testAdress() {
        log.info(addressSuggestConfiguration.getTencentkeys().toString());
    }
}