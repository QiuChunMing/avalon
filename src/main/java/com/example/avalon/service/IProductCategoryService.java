package com.example.avalon.service;

import com.example.avalon.entity.ProductCategory;

import java.util.List;

public interface IProductCategoryService {

    ProductCategory findOne(Integer categoryid);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
