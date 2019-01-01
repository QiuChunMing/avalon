package com.example.avalon.service.shop;

import com.example.avalon.entity.food.Menu;
import com.example.avalon.repository.MenuRepository;
import com.example.avalon.service.ServiceResult;
import com.example.avalon.web.form.AddMenuForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Transactional
    public ServiceResult<Menu> addMenu(AddMenuForm addMenuForm) {
        if (addMenuForm == null
                || addMenuForm.getRestaurant_id() == 0
                || addMenuForm.getName() == null) {
            return new ServiceResult<>(false, "参数为空");
        }

        //进行赋值
        Menu menu = new Menu();
        menu.setRestaurantId(addMenuForm.getRestaurant_id());
        menu.setDescription(addMenuForm.getDescription());
        menu.setName(addMenuForm.getName());

        Menu save = menuRepository.save(menu);

        return ServiceResult.of(save);
    }

    public ServiceResult<List<Menu>> getAllMenus() {
        List<Menu> all = menuRepository.findAll();
        return ServiceResult.of(all);
    }

    public ServiceResult<Menu> getMenuByMenuId(Integer id) {
        Optional<Menu> byId = menuRepository.findById(id);
        return byId.isPresent()?(ServiceResult.of(byId.get()))
                :(new ServiceResult<>(false,"无此菜单"));
    }
}
