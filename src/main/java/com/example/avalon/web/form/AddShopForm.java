package com.example.avalon.web.form;


import com.example.avalon.entity.shop.Activities;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class AddShopForm {

    /*
    {
    "name":"xiao",
    "address":"上海市宝山区上大路99号",
    "latitude":31.31601,
    "longitude":121.393402,
    "description":"",
    "phone":155,
    "promotion_info":"",
    "float_delivery_fee":5,
    "float_minimum_order_amount":20,
    "is_premium":true,
    "delivery_mode":true,
    "new":true,
    "bao":true,
    "zhun":true,
    "piao":true,
    "startTime":"05:45",
    "endTime":"06:00",
    "image_path":"167ff1691b91.png",
    "business_license_image":"167ff1695322.png",
    "catering_service_license_image":"167ff16ba1d3.png",
    "activities":[
        {
            "icon_name":"减",
            "name":"满减优惠",
            "description":"满30减5，满60减8"
        },
        {
            "icon_name":"新",
            "name":"新用户立减",
            "description":"郭德纲"
        }
    ],
    "category":"快餐便当"
}
     */

    private String name;
    private String address;
    private String description;
    private String latitude;
    private String longitude;
    //运费
    private int floatDeliveryFee;
    private String phone;
    //起送价
    private int floatMinimumOrderAmount;
    //品牌店铺
    private boolean isPremium;
    //新开店铺
    private boolean isNew;
    private boolean bao;
    private boolean zhun;
    private boolean piao;

    private String startTime;
    private String endTime;
    private String promotionInfo;
    private String imagePath;
    private String category;
    //营业执照地址
    private String businessLicenseImage;
    private String cateringServiceLicenseImage;
    //商铺活动：示例：[{icon_name:'新', name:'新用户立减', description: ''}]
    private List<Activities> activities;

}
