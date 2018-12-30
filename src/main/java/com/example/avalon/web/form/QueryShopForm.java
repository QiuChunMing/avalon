package com.example.avalon.web.form;

import lombok.Data;

import java.util.List;

@Data
public class QueryShopForm {
    private String latitude;
    private String longitude;
    private int offset;
    private int limit;
    private int restaurantCategoryId;
    //排序方式：1：起送价2：配送速度3.评分4.智能排序（默认）5.距离最近6.销量最高
    private int orderBy;
    private List<Integer> deliveryMode;
    private List<Integer> supportsIds;
    private List<Integer> restaurantCategoryIds;
}
