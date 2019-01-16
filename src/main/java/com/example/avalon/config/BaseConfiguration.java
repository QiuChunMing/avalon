package com.example.avalon.config;

import com.example.avalon.utils.upload.UploadManagerImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BaseConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public UploadManagerImp uploadManager() {
        return new UploadManagerImp();
    }

}
