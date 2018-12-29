package com.example.avalon.service.shop;

import com.example.avalon.AvalonApplicationTests;
import com.example.avalon.web.form.AddShopForm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ShopServiceTest extends AvalonApplicationTests {

    @Autowired
    private ShopService shopService;


    @Test
    public void addShop() {
        AddShopForm addShopForm = new AddShopForm();
        addShopForm.setAddress("广东");
        addShopForm.setName("小店");
        addShopForm.setActivities("[\n" +
                "      {\n" +
                "        icon_name: \"减\",\n" +
                "        name: \"满减优惠\",\n" +
                "        description: \"满30减5，满60减8\",\n" +
                "        icon_color: \"f07373\",\n" +
                "        id: 1,\n" +
                "        _id: \"591bec73c2bbc84a6328a1e7\"\n" +
                "      },\n" +
                "      {\n" +
                "        icon_name: \"特\",\n" +
                "        name: \"优惠大酬宾\",\n" +
                "        description: \"是对冯绍峰的上市房地产\",\n" +
                "        icon_color: \"EDC123\",\n" +
                "        id: 2,\n" +
                "        _id: \"591bec73c2bbc84a6328a1e6\"\n" +
                "      }\n" +
                "    ]");
        shopService.addShop(addShopForm);
    }
}