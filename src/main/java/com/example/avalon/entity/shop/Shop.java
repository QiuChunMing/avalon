package com.example.avalon.entity.shop;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
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

    private String orderLeadTime;

    private String distance;

    private String imagePath;

    private short isPremium;

    private short isNew;

    /*纬度*/
    private double latitude;

    /*经度*/
    private double longtitude;

    /*证书图片链接*/
    private String bussinessLicenseImage;

    /*证书图片链接*/
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
}
