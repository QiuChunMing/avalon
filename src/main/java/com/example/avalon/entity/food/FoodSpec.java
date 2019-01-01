package com.example.avalon.entity.food;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class FoodSpec {
    @Id
    @GeneratedValue
    private Integer id;
    private String specs;
    private double packingFee;
    private double price;
}
