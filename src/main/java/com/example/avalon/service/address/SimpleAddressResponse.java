package com.example.avalon.service.address;

import lombok.Data;

@Data
public class SimpleAddressResponse {
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private String geohash;
}
