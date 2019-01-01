package com.example.avalon.entity.food;

import com.example.avalon.entity.food.Food;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Menu {

    /*
    {
        "name": "热销榜",
        "description": "大家喜欢吃，才叫真好吃。",
        "id": 6,
        "restaurant_id": 6,
        "foods": [],
        "type": 1,
        "icon_url": "5da3872d782f707b4c82ce4607c73d1ajpeg",
        "is_selected": true,
        "__v": 0
    }
     */

    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private boolean isSelected;
    private String iconUrl;
    private String name;
    private Integer restaurantId;
    private Integer type;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Set<Food> foods;
}
