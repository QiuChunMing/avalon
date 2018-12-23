package com.example.avalon.service;

import com.example.avalon.entity.shop.Shop;
import com.example.avalon.web.form.AddShopForm;
import com.example.avalon.dto.ShopDetail;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
//
//    @Autowired
//    private ShopRepository shopRepository;

    public ServiceResult<ShopDetail> addShop(AddShopForm form) {
        Shop shop = new Shop();
        
        return null;
    }
}
