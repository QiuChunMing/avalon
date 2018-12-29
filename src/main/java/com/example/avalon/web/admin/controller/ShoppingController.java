package com.example.avalon.web.admin.controller;

import com.example.avalon.service.ServiceResult;
import com.example.avalon.service.shop.ShopService;
import com.example.avalon.web.form.AddShopForm;
import com.example.avalon.dto.AddShopResponse;
import com.example.avalon.dto.ShopDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

@Controller("/shopping")
public class ShoppingController {

    @Autowired
    private ShopService shopService;

    public AddShopResponse addShop(AddShopForm addShopForm, BindingResult bindingResult) {
        AddShopResponse response = new AddShopResponse();
        if (bindingResult.hasErrors()) {
            response.setStatus(0);
            response.setType("ERROR_PARAM");
            response.setMessage(bindingResult.getAllErrors().toString());
            return response;
        }
        ServiceResult<ShopDetail> shop = shopService.addShop(addShopForm);

        if (shop.isSuccess()) {
            response.setShopDetail(shop.getResult());
        } else {
            response.setStatus(0);
            response.setMessage(shop.getMessage());
            response.setType("DATA_ERROR");
        }
        return response;
    }
}
