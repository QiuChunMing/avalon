package com.example.avalon.entity.food;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class FoodAttribute {
    @Id
    @GeneratedValue
    private Integer id;
    private String attribute;

    public FoodAttribute() {
    }

    public FoodAttribute(String attribute) {
        this.attribute = attribute;
    }
}
