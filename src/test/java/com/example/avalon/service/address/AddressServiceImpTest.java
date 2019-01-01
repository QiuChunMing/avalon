package com.example.avalon.service.address;

import com.example.avalon.AvalonApplicationTests;
import com.example.avalon.service.ServiceResult;
import com.example.avalon.service.address.response.GetDistanceResponse;
import com.example.avalon.service.address.response.SearchPlaceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class AddressServiceImpTest extends AvalonApplicationTests {
    @Autowired
    private IAddressService addressService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void guessPosition() {
    }

    @Test
    public void searchPlace() {
        ServiceResult<SearchPlaceResponse> result = addressService.searchPlace("肯德基", "广州");
        SearchPlaceResponse result1 = result.getResult();
        try {
            log.debug(objectMapper.writeValueAsString(result1));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void getDistance() {
    }

    @Test
    public void geocoder() {
    }

    @Test
    public void getpois() {
    }

    @Test
    public void addressSuggest() {
        ServiceResult<List<SimpleAddressResponse>> listServiceResult = addressService.AddressSuggest("肯德基", "广州");
        if (listServiceResult.isSuccess()) {
            List<SimpleAddressResponse> result = listServiceResult.getResult();
            try {
                log.debug(objectMapper.writeValueAsString(result));
            } catch (JsonProcessingException e) {
                log.error(e.getMessage());
            }
        } else {
            log.error(listServiceResult.getMessage());
        }
    }

    @Test
    public void getSimpleDistance() {
        ServiceResult<List<SimpleDistanceResponse>> distance
                = addressService.getSimpleDistance("31.31601,121.393402", "31.31601,121.393402|31.31601,121.393402|31.31601,121.393402");
        try {
            log.debug(objectMapper.writeValueAsString(distance.getResult()));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}