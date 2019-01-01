package com.example.avalon.service.shop;

import com.example.avalon.dto.ShopDetail;
import com.example.avalon.entity.shop.Activities;
import com.example.avalon.entity.shop.Shop;
import com.example.avalon.entity.shop.Supports;
import com.example.avalon.repository.ShopRepository;
import com.example.avalon.service.CategoryService;
import com.example.avalon.service.ServiceResult;
import com.example.avalon.service.address.IAddressService;
import com.example.avalon.service.address.SimpleDistanceResponse;
import com.example.avalon.service.address.response.GetDistanceResponse;
import com.example.avalon.web.form.AddShopForm;
import com.example.avalon.web.form.QueryShopForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Slf4j
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private CategoryService categoryService;

    @Transactional
    public ServiceResult<Shop> addShop(AddShopForm form) {

        if (StringUtils.isEmpty(form.getLatitude())
                || StringUtils.isEmpty(form.getLongitude())
                || StringUtils.isEmpty(form.getAddress())) {
            return new ServiceResult<>(false, "店铺地址不能为空");
        }

        if (form.getName() != null) {
            Shop byName = shopRepository.findByName(form.getName());
            if (byName != null) {
                return new ServiceResult<>(false, "已存在同名店铺");
            }
        } else {
            return new ServiceResult<>(false, "店名不能为空");
        }

        Shop shop = new Shop();
        BeanUtils.copyProperties(form, shop);

        List<Activities> activitiesList = form.getActivities();
        Set<Activities> activitiesSet = new HashSet<>();
        for (Activities activity : activitiesList) {

            if (activity != null && activity.getIconName() != null) {
                switch (activity.getIconName()) {
                    case "减":
                        activity.setIconColor("f07373");
                        break;
                    case "特":
                        activity.setIconColor("EDC123");
                        break;
                    case "新":
                        activity.setIconColor("70bc46");
                        break;
                    case "领":
                        activity.setIconColor("E3EE0");
                        break;
                    default:
                        log.warn("{} 不支持的活动类型", activity.getIconName());
                        break;
                }
                activity.setRestaurantId(shop.getId());
                activitiesSet.add(activity);
            }

        }
        shop.setActivities(activitiesSet);

        Set<Supports> supportsSet = new HashSet<>();
        if (form.isBao()) {
            Supports supports = new Supports(
                    "999999", "保", "外卖保"
                    , "已加入“外卖保”计划，食品安全有保障");
            supportsSet.add(supports);
        }
        if (form.isZhun()) {
            Supports supports = new Supports(
                    "57A9FF", "准", "准时达"
                    , "准时必达，超时秒赔");
            supportsSet.add(supports);
        }
        if (form.isPiao()) {
            Supports supports = new Supports(
                    "999999", "票", "开发票"
                    , "该商家支持开发票，请在下单时填写好发票抬头");
            supportsSet.add(supports);
        }

        shop.setSupports(supportsSet);
        shopRepository.save(shop);
        return ServiceResult.of(shop);
    }


    public ServiceResult<List<Shop>> getRestaurants(QueryShopForm form) {
        if (StringUtils.isEmpty(form.getLatitude())
                || StringUtils.isEmpty(form.getLongitude())) {
            return new ServiceResult<>(false, "latitude or longitude can not be empty");
        }

        //对应食品种类
        List<Integer> restaurantCategoryIds = form.getRestaurantCategoryIds();
        if (restaurantCategoryIds != null && restaurantCategoryIds.size() > 0) {

        }
        //查找距离
        //TODO

        //多维度排序
        //TODO 按照距离，评分，销量排序
        List<Shop> all = shopRepository.findAll();
        return ServiceResult.of(all);
    }

    public ServiceResult<List<ShopDetail>> searchRestaurant(String geohash, String keyword) {
        if (StringUtils.isEmpty(geohash) || StringUtils.isEmpty(keyword) || !geohash.contains(",")) {
            return new ServiceResult(false, "经纬度参数错误或关键词错误");
        }

        List<Shop> all = shopRepository.findAll();
        //查找距离信息
        StringBuilder to = new StringBuilder();
        for (int i = 0; i < all.size(); i++) {
            String splitStr = (i == all.size() - 1) ? "" : "|";
            to.append(all.get(i))
                    .append(",")
                    .append(all.get(i))
                    .append(splitStr);
        }
        ServiceResult<List<SimpleDistanceResponse>> distance
                = addressService.getSimpleDistance(geohash, to.toString());
        List<ShopDetail> details = new ArrayList<>();
        all.forEach(shop -> {
            ShopDetail shopDetail = new ShopDetail();
            BeanUtils.copyProperties(shop, shopDetail);
            details.add(shopDetail);
        });
        if (!distance.isSuccess()) {
            return new ServiceResult(false, distance.getMessage());
        } else {
            for (int i = 0; i < distance.getResult().size(); i++) {
                details.get(i).setDistance(distance.getResult().get(i).getDistance());
                details.get(i).setOrderLeadTime(distance.getResult().get(i).getOrderLeadTime());
            }
            return ServiceResult.of(details);
        }

    }
}
