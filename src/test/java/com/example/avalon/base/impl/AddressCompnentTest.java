package com.example.avalon.base.impl;

import com.example.AvalonApplication;
import com.example.avalon.base.response.GeocoderResponse;
import com.example.avalon.base.response.GetDistanceResponse;
import com.example.avalon.base.response.SearchPlaceResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AvalonApplication.class)
@Slf4j
public class AddressCompnentTest {

    @Autowired
    private AddressCompnent addressCompnent;

    @Test
    public void guessPosition() {
       log.debug("guess position is:{}",addressCompnent.guessPosition(null));
    }

    @Test
    public void getDistanceResponse() {
        GetDistanceResponse distance = addressCompnent.getDistance("40,116", "41,121");
        log.info("distance instance is:{}", distance.getMessage());
    }

    @Test
    public void geocoder() {
        GeocoderResponse geocoder = addressCompnent.geocoder("");
        log.info("根据ip查询位置:{}",geocoder.getResult().getAddress());
    }

    @Test
    public void searchPlace() {
        SearchPlaceResponse searchPlaceResponse = addressCompnent.searchPlace("广东", "");
        log.info("{}",searchPlaceResponse.getMessage());

        SearchPlaceResponse searchPlace = addressCompnent.searchPlace(null, null);
        Assert.assertNull(searchPlace);
    }

    @Test
    public void getpois() {
        GeocoderResponse response = addressCompnent.getpois(String.valueOf(31.22967), String.valueOf(121.4762));
        log.debug("response is {}",response);
    }
}