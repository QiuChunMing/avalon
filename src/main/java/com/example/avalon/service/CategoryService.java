package com.example.avalon.service;

import com.example.avalon.entity.Category;
import com.example.avalon.repository.CategoryRepository;
import com.example.avalon.dto.CategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    public ServiceResult<List<CategoryDTO>> getCategories() {
        List<Category> categoryList = getCategoriesList();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        log.debug(categoryList.toString());

        wrapCategoryListToVOList(categoryList, categoryDTOList);
        return ServiceResult.of(categoryDTOList);
    }

    @Transactional
    public ServiceResult addCategory(String type) {
        String[] types = type.split("/");
        String mainCategory = types[0].trim();
        String subCategory = types[1].trim();
        if (StringUtils.isEmpty(mainCategory) || StringUtils.isEmpty(subCategory)) {
            return ServiceResult.fail();
        }
        log.debug("mainCategory {}",mainCategory);
        log.debug("subCategory {}",subCategory);

        Category categoryMain = categoryRepository.findFirstByName(mainCategory);
        Category categorySub = categoryRepository.findFirstByName(subCategory);

        log.debug("categoryMain {}",categoryMain);
        log.debug("categorySub {}",categorySub);
        if (categoryMain == null || categorySub == null) {
            return ServiceResult.fail();
        }
        if (categorySub.getParentId() != categoryMain.getId() && categoryMain.getId() != categorySub.getId()) {
            return ServiceResult.fail();
        }
        log.debug("{}",categoryMain.getCount());
        log.debug("{}",categorySub.getCount());

        categoryMain.setCount(categoryMain.getCount() + 1);
        categoryRepository.save(categoryMain);

        if (categorySub.getId() != categoryMain.getId())  {
            categorySub.setCount(categorySub.getCount() + 1);
            log.debug("{},{}",categorySub.getId(),categoryMain.getId());
            categoryRepository.save(categorySub);
        }
        return ServiceResult.success();
    }


    private void wrapCategoryListToVOList(List<Category> categoryList, List<CategoryDTO> categoryDTOList) {

        for (int i = 0; i < categoryList.size(); i++) {
            Category category = categoryList.get(i);
            CategoryDTO categoryDTO = new CategoryDTO();
            BeanUtils.copyProperties(category, categoryDTO);
            categoryDTO.setImage_url(category.getImageUrl());
            categoryDTOList.add(categoryDTO);
            categoryDTO.setSub_categories(new ArrayList<>());

            wrapCategoryListToVOList(category.getCategory(), categoryDTO.getSub_categories());
            generateTheFirstCategory(category, categoryDTO);
        }
    }

    private void generateTheFirstCategory(Category category,CategoryDTO categoryDTO) {
        if (category.getParentId() == 0) {
            if (categoryDTO.getSub_categories() != null) {
                CategoryDTO categoryDTO1 = new CategoryDTO();
                BeanUtils.copyProperties(category, categoryDTO1);
                categoryDTO1.setName("全部"+category.getName());
                categoryDTO1.setImage_url(category.getImageUrl());
                categoryDTO1.setSub_categories(Collections.EMPTY_LIST);

                List<CategoryDTO> sub_categories = categoryDTO.getSub_categories();
                int num = 0;
                for (int i = 0; i < sub_categories.size(); i++) {
                    CategoryDTO vo = sub_categories.get(i);
                    num += vo.getCount();
                }
                categoryDTO1.setCount(categoryDTO1.getCount() - num);
                sub_categories.add(0, categoryDTO1);
            }
        }
    }


    private List<Category> getCategoriesList() {
        List<Category> allCategory = categoryRepository.findAll();

        List<Category> rootCategory = new ArrayList<>();

        //找出根种类
        for (Category category : allCategory) {
            if (category.getParentId() != category.getId() && category.getParentId() == 0) {
                rootCategory.add(category);
            }
        }


        //递归查找根种类下的次级种类
        for (Category category : rootCategory) {
            if (category.getParentId() != category.getId()) {
                List<Category> subCategory = getSubCategory(category, allCategory);
                category.setCategory(subCategory);
            }
        }

        return rootCategory;
    }

    private List<Category> getSubCategory(Category category, List<Category> allCategory) {
        //找出子类型
        List<Category> subCategories = new ArrayList<>();
        for (Category category1 : allCategory) {
            if (category1.getParentId() != category1.getId()//避免无法退出递归
                    && category.getId() == category1.getParentId()) {
                subCategories.add(category1);
            }
        }
        //递归查找
        for (Category subCategory : subCategories) {
            log.debug("{}", subCategory.getCategory());
            subCategory.setCategory(getSubCategory(subCategory, allCategory));
        }

        if (subCategories.size() == 0) {
            return Collections.EMPTY_LIST;
        }

        return subCategories;
    }
}
