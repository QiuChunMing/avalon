package com.example.avalon.entity.shop;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@ToString
public class Supports {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer restaurantId;
    private String iconColor;
    private String iconName;
    private String name;
    private String description;
    @ManyToMany(targetEntity = Supports.class, cascade = CascadeType.ALL)
    @JoinTable(name = "shop_supports"
            , joinColumns = {@JoinColumn(name = "supports_id"
            , referencedColumnName = "id")})
    private Set<Shop> shop;

    public Supports(String iconColor, String iconName, String name, String description) {
        this.iconColor = iconColor;
        this.iconName = iconName;
        this.name = name;
        this.description = description;
    }

    public Supports() {
    }
}
