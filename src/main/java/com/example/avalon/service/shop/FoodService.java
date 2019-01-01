package com.example.avalon.service.shop;

import com.example.avalon.entity.food.Food;
import com.example.avalon.entity.food.FoodAttribute;
import com.example.avalon.entity.food.FoodSpec;
import com.example.avalon.entity.shop.Shop;
import com.example.avalon.repository.FoodAttributeRepository;
import com.example.avalon.repository.FoodRepository;
import com.example.avalon.repository.FoodSpecRepository;
import com.example.avalon.repository.ShopRepository;
import com.example.avalon.service.ServiceResult;
import com.example.avalon.web.form.AddFoodForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class FoodService {


    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private FoodSpecRepository foodSpecRepository;

    @Autowired
    private FoodAttributeRepository foodAttributeRepository;


    public ServiceResult addFood(AddFoodForm addFoodForm) {
        if (addFoodForm == null) {
            return new ServiceResult(false,"addFoodForm为空");
        }
        Food food = new Food();
        BeanUtils.copyProperties(addFoodForm, food);
        //TODO 默认添加进热销榜
        food.setMenuId(addFoodForm.getCategory_id());
        if (StringUtils.isEmpty(addFoodForm.getName())) {
            return new ServiceResult(false, "必须填写食品名称");
        } else if (addFoodForm.getSpecs().size() == 0) {
            return new ServiceResult(false, "至少填写一种规格");
        } else if (StringUtils.isEmpty(addFoodForm.getRestaurantId())) {
            return new ServiceResult(false, "食品类型ID错误");
        }

        Optional<Shop> shopOptional = shopRepository.findById(addFoodForm.getRestaurantId());
        if (!shopOptional.isPresent()) {
            return new ServiceResult(false, "店铺不存在");
        }

        //添加属性
        Set<FoodAttribute> attributes = new HashSet<>();
        for (String s : addFoodForm.getAttributes()) {
            log.debug(s);
            FoodAttribute attribute = new FoodAttribute(s);
            attributes.add(attribute);
        }
        food.setAttributes(attributes);
        Set<FoodSpec> specs = new HashSet<>();
        //添加规格
        for (AddFoodForm.SpecsBean specsBean : addFoodForm.getSpecs()) {
            FoodSpec foodSpec = new FoodSpec();
            BeanUtils.copyProperties(specsBean,foodSpec);
            specs.add(foodSpec);
        }
        food.setFoodSpecs(specs);

        foodAttributeRepository.saveAll(attributes);
        foodSpecRepository.saveAll(specs);
        foodRepository.save(food);

        return ServiceResult.success();
    }
}
