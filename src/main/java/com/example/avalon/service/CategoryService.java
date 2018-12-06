package com.example.avalon.service;

import com.example.avalon.entity.Category;
import com.example.avalon.repository.CategoryRepository;
import com.example.avalon.web.vo.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ServiceResult<List<CategoryVO>> getCategories() {
        List<Category> mainCategories = categoryRepository.findAllByLevel(1);
        List<Category> allSubCategories = categoryRepository.findAllByLevel(2);

        log.debug(mainCategories.toString());
        log.debug(allSubCategories.toString());

        List<CategoryVO> categories = new ArrayList<>();

        CategoryVO firstCatogery = new CategoryVO();
        firstCatogery.setName("全部商家");
        firstCatogery.setIds(mainCategories.stream()
                .map(c -> c.getId())
                .collect(Collectors.toList()));

        categories.add(firstCatogery);

        //对二级菜单根据父级菜单进行分类
        Map<Integer, List<Category>> collect = allSubCategories.stream()
                .collect(Collectors.groupingBy(Category::getParentId));

        collect.forEach((i,j)->log.debug("collect {} :{}",i,String.valueOf(j.size())));
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
            for (Category subCategory : subCategories) {
                CategoryVO categoryVO = new CategoryVO();
                BeanUtils.copyProperties(subCategory,categoryVO);
                subCategoriesVO.add(categoryVO);
            }

            subCategoryVO.setSub_categories(subCategoriesVO);
            categories.add(subCategoryVO);
        }

        return ServiceResult.of(categories);
    }
}
