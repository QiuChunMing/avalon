package com.example.avalon.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

//@Entity
@Data
public class Food {

    @Id
    @GeneratedValue
    private int foodId;

    private String name;

    /*评分*/
    private int rating;

    private int isFeatured;

    private int restaurantId;

    private int categoryId;

    private String pinyinName;

    private String description;

    private int monthSales;

    private String imagePath;

    private String specification;

    private LocalDate serverUtc;

    private short isEssential;

    private double originalPrice;

    private double packingFee;

    /*库存*/
    private int stock;

    private short soldOut;

    private String displayTime;

}
