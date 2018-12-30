package com.example.avalon.entity.shop;

import com.example.avalon.entity.Category;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString
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

    @ManyToMany(targetEntity = Activities.class, cascade = CascadeType.ALL)
    @JoinTable(name = "shop_activities"
            , joinColumns = {@JoinColumn(name = "shop_id"
            , referencedColumnName = "id")})
    private Set<Activities> activities;

    @OneToOne(targetEntity = Identification.class, cascade = CascadeType.ALL)
    private Identification identification;

    @ManyToMany(targetEntity = Supports.class, cascade = CascadeType.ALL)
    @JoinTable(name = "shop_supports"
            , joinColumns = {@JoinColumn(name = "shop_id"
            , referencedColumnName = "id")})
    private Set<Supports> supports;

    private String category;
}
