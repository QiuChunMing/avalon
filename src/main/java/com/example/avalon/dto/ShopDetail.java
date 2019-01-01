package com.example.avalon.dto;

import com.example.avalon.entity.shop.Shop;
import lombok.Data;

@Data
public class ShopDetail extends Shop {
    private String distance;
    private String orderLeadTime;
}
