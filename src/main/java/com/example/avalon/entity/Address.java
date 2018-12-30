package com.example.avalon.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Address {
    private int id;
    private String address;
    private String phone;
    private int isValid;
    private LocalDate createAt;
    private String phoneBk;
    private String name;
    private int tagType;
    private String stGeoHash;
    private String addressDetail;
    private int sex;
    private int cityId;
    private int isUserDefault;
    private String tag;
    private int isDeliverable;
    private int agentFee;
    private int deliverAmount;
    private int phoneHadBound;
}
