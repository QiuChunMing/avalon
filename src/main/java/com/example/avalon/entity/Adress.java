package com.example.avalon.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Adress {
    private int id;
    private String adress;
    private String phone;
    private int isValid;
    private LocalDate createAt;
    private String phoneBk;
    private String name;
    private int tagType;
    private String stGeoHash;
    private String addressDetail;
    private int sex;
    private int cityid;
    private int isUserDefault;
    private int cityId;
    private String tag;
    private int isDeliverable;
    private int agentFee;
    private int deleverAmount;
    private int phoneHadBound;
}
