package com.example.avalon.entity.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@ToString
public class Activities {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer restaurantId;
    @JsonProperty("icon_name")
    private String iconName;
    private String iconColor;
    private String name;
    private String description;
    @ManyToMany(targetEntity = Shop.class,cascade = CascadeType.ALL)
    @JoinTable(name = "shop_activities"
            ,joinColumns = {@JoinColumn(name = "activities_id"
            ,referencedColumnName = "id")})
    private Set<Shop> shop;

    public Activities() {
    }

    public Activities(String iconName) {
        this.iconName = iconName;
    }
}
