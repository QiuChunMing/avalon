package com.example.avalon.entity.food;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
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
    private int menuId;
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
    @OneToMany(targetEntity = FoodSpec.class)
    @JoinColumn(name = "food_id")
    private Set<FoodSpec> foodSpecs;
    @OneToMany(targetEntity = FoodAttribute.class)
    @JoinColumn(name = "food_id")
    private Set<FoodAttribute> attributes;
}
