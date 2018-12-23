package com.example.avalon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PoisDTO {

    /**
     * name : 上海迪士尼乐园
     * address : 上海市浦东新区申迪西路753号
     * latitude : 31.14419
     * longitude : 121.66034
     * geohash : 31.14419,121.66034
     */

    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private String geohash;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }
}
