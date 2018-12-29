package com.example.avalon.web.form;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class AddShopForm {


    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    private String description;
    //运费
    private int floatDeliveryFee;
//    @NotEmpty
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
//    @NotEmpty
    private String latitude;
//    @NotEmpty
    private String longitude;
    private String startTime;
    private String endTime;
    private String promotionInfo;
    private String imagePath;
    private String category;
    //营业执照地址
    private String businessLicenseImage;
    private String cateringServiceLicenseImage;
    //商铺活动：示例：[{icon_name:'新', name:'新用户立减', description: ''}]
    private List<String> activities;

}
