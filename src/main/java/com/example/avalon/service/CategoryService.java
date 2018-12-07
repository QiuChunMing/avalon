package com.example.avalon.service;

import com.example.avalon.entity.Category;
import com.example.avalon.repository.CategoryRepository;
import com.example.avalon.web.vo.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryService {


    static final int ROOT_ID = 0;

    @Autowired
    private CategoryRepository categoryRepository;

    public ServiceResult<List<CategoryVO>> getCategories() {

        List<CategoryVO> categories = new ArrayList<>();

        List<Category> all = categoryRepository.findAll();
        Map<Integer, Map<Integer, List<Category>>> map = all.stream().collect(
                Collectors.groupingBy(Category::getLevel,
                        Collectors.groupingBy(Category::getParentId)));

        int maxLevel = map.size();
        List<Integer> ids = new ArrayList<>();
        List<Category> list = map.get(1).get(0);
        //添加第一个类别（总的类别）
        CategoryVO firstCatogery = new CategoryVO();
        firstCatogery.setName("全部商家");
        firstCatogery.setIds(map.get(1).get(0).stream()
                .map(Category::getId).collect(Collectors.toList()));
        categories.add(firstCatogery);

        //TODO
        List<Category> mainCategories = map.get(1).get(ROOT_ID);


        //对二级菜单根据父级菜单进行分类
        Map<Integer, List<Category>> collect = map.get(2);

        collect.forEach((i, j) -> log.debug("collect {} :{}", i, String.valueOf(j.size())));
        //按照一级菜单Id,顺序取出分类后的二级菜单
        for (Category mainCategory : mainCategories) {
            CategoryVO subCategoryVO = new CategoryVO();
            //设置Id
            int mainCategoryId = mainCategory.getId();
            subCategoryVO.setId(mainCategoryId);
            subCategoryVO.setIds(Arrays.asList(mainCategoryId));

            //将二级菜单Entity转换为VO
            List<Category> subCategories = collect.get(mainCategoryId);
            List<CategoryVO> subCategoriesVO = new ArrayList<>();
            wrapCategoryToVO(subCategories, subCategoriesVO);

            subCategoryVO.setSub_categories(subCategoriesVO);
            categories.add(subCategoryVO);
        }

        return ServiceResult.of(categories);
    }

    private void wrapCategoryToVO(List<Category> categories, List<CategoryVO> categoryVOS) {
        for (Category category : categories) {
            CategoryVO categoryVO = new CategoryVO();
            BeanUtils.copyProperties(category, categoryVO);
            categoryVOS.add(categoryVO);
        }
    }
}
