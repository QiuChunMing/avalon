package com.example.avalon.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue
    private int catogoryId;

    private int id;

    private String imageUrl;

    private int level;

    private String name;//例如：特色菜系

    private int parentId;
}
