package com.example.avalon.service.shop;

import com.example.avalon.dto.ShopDetail;
import com.example.avalon.entity.shop.Activities;
import com.example.avalon.entity.shop.Shop;
import com.example.avalon.repository.ActivitiesRepository;
import com.example.avalon.repository.ShopRepository;
import com.example.avalon.service.ServiceResult;
import com.example.avalon.web.form.AddShopForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ActivitiesRepository activitiesRepository;

    @Transactional
    public ServiceResult<ShopDetail> addShop(AddShopForm form) {
        Shop shop = new Shop();
        BeanUtils.copyProperties(form, shop);
        Shop save = shopRepository.save(shop);

        List<String> stringList = form.getActivities();
        List<Activities> activitiesList = new ArrayList<>();
        for (String activity : stringList) {
            Activities activities = toActivities(activity);
            switch (activities.getIconName()) {
                case "减":
                    activities.setIconColor("f07373");
                    break;
                case "特":
                    activities.setIconColor("EDC123");
                    break;
                case "新":
                    activities.setIconColor("70bc46");
                    break;
                case "领":
                    activities.setIconColor("E3EE0");
                    break;
            }
            activitiesList.add(activities);
        }

        return ServiceResult.of();
    }


    private Activities toActivities(String activities) {
        Activities activities1 = null;
        try {
            activities1 = objectMapper.readValue(activities, Activities.class);
        } catch (IOException e) {
            log.error("can not convert to activities {}",activities);
        }
        return activities1;
    }
}
