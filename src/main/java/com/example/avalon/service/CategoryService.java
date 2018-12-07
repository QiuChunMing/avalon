package com.example.avalon.service;

import com.example.avalon.entity.Category;
import com.example.avalon.repository.CategoryRepository;
import com.example.avalon.web.vo.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    public ServiceResult<List<CategoryVO>> getCategories() {
        List<Category> categoryList = getCategoriesList();
        List<CategoryVO> categoryVOList = new ArrayList<>();

        wrapCategoryListToVOList(categoryList, categoryVOList);
        return ServiceResult.of(categoryVOList);
    }

    private void wrapCategoryListToVOList(List<Category> categoryList, List<CategoryVO> categoryVOList) {
        log.debug("category string : {}", categoryList.toString());
        log.debug("category string : {}", categoryVOList.toString());
        for (Category category : categoryList) {
            CategoryVO categoryVO = new CategoryVO();
            BeanUtils.copyProperties(category,categoryVO);
            categoryVOList.add(categoryVO);
            categoryVO.setSub_categories(new ArrayList<>());

            if (category.getCategory() != null && category.getCategory().size() > 0) {
                wrapCategoryListToVOList(category.getCategory(),categoryVO.getSub_categories());
            }
        }
    }



    private List<Category> getCategoriesList() {
        List<Category> allCategory = categoryRepository.findAll();

        List<Category> rootCategory = new ArrayList<>();

        //找出根种类
        for (Category category : allCategory) {
            if (category.getParentId() == 0) {
                rootCategory.add(category);
            }
        }
        //递归查找根种类下的次级种类
        for (Category category : rootCategory) {
            List<Category> subCategory = getSubCategory(category, allCategory);
            category.setCategory(subCategory);
        }

        return rootCategory;
    }

    private List<Category> getSubCategory(Category category, List<Category> allCategory) {
        //找出子类型
        List<Category> subCatogories = new ArrayList<>();
        for (Category category1 : allCategory) {
            if (category.getId() == category1.getParentId()) {
                subCatogories.add(category1);
            }
        }
        //递归查找
        for (Category subCatogory : subCatogories) {
            category.setCategory(getSubCategory(subCatogory, allCategory));
        }

        if (subCatogories.size() == 0) {
            return Collections.EMPTY_LIST;
        }

        return subCatogories;
    }
}
