package com.example.avalon.dto;

import com.example.avalon.entity.shop.Shop;
import lombok.Data;

@Data
public class AddShopResponse {
    private int status;
    private String type;
    private String message;
    private String success;
    private Shop shop;
}
