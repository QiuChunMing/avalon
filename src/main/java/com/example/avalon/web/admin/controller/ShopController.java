package com.example.avalon.web.admin.controller;

import com.example.avalon.dto.AddShopResponse;
import com.example.avalon.entity.shop.Shop;
import com.example.avalon.service.ServiceResult;
import com.example.avalon.service.shop.ShopService;
import com.example.avalon.web.form.AddShopForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/shopping")
public class ShopController {

    @Autowired
    private ShopService shopService;

    public AddShopResponse addShop(@RequestBody AddShopForm addShopForm, BindingResult bindingResult) {
        AddShopResponse response = new AddShopResponse();
        if (bindingResult.hasErrors()) {
            response.setStatus(0);
            response.setType("ERROR_PARAM");
            response.setMessage(bindingResult.getAllErrors().toString());
            return response;
        }
        ServiceResult<Shop> shop = shopService.addShop(addShopForm);

        if (shop.isSuccess()) {
            response.setShop(shop.getResult());
        } else {
            response.setStatus(0);
            response.setMessage(shop.getMessage());
            response.setType("DATA_ERROR");
        }
        return response;
    }
}
