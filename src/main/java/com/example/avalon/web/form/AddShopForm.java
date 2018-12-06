package com.example.avalon.web.form;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class AddShopForm {

    @NotNull
    private int restaurantId;

    private String name;

    private String address;

    private String description;

    private float floatDeliveryFee;

    private String phone;

    private float floatMinimumOrderAmount;

    private boolean isPremium;

    private boolean isNew;

    private float latitude;

    private float longitude;

    private String startTime;

    private String endTime;

    private String promotionInfo;

    private String imagePath;

    private String category;

    private String businessLicenseImage;

    private String cateringServiceLicenseImage;

    private List<String> activities;

}
