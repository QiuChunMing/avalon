package com.example.avalon.service.address;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "avalon.address-suggest")
@Data
public class AddressSuggestConfiguration {
    private List<String> tencentkeys;

    private List<String> baiduKeys;

    private String guessPositionUrl;

    private String searchPlaceUrl;

    private String getDistanceUrl;

    private String geocoderUrl;

    private String getpoisUrl;
}
