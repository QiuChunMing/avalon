package com.example.avalon.entity.shop;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Data
public class Shop {
    public Shop() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private String address;
    private String imagePath;
    private short isPremium;
    private short isNew;
    /*纬度*/
    private double latitude;
    /*经度*/
    private double longitude;
    private String businessLicenseImage;
    private String cateringServiceLicenseImage;
    private String phone;
    /*评分*/
    private int rating;
    private int ratingCount;
    private String piecewiseAgentFee;
    /*欢迎光临，用餐高峰请提前下单*/
    private String promotionInfo;
    private int recentOrderNum;
    private int status;
    private String openHours;
    @Transient
    private List<Activities> activities;
    @Transient
    private Identification identification;
}
