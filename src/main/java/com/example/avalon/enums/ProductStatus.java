package com.example.avalon.enums;

import lombok.Getter;

@Getter
public enum ProductStatus implements CodeEnum{
    UP(0,"上架"),
    DOWN(1,"下架");

    private Integer code;
    private String message;

    ProductStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
