package com.example.avalon.entity.shop;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Activities {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer restaurantId;
    private String iconName;
    private String iconColor;
    private String name;
    private String description;
}
