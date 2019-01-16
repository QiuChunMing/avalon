package com.example.avalon.controller;


import com.example.avalon.entity.ProductCategory;
import com.example.avalon.entity.ProductInfo;
import com.example.avalon.service.IProductCategoryService;
import com.example.avalon.service.IProductInfoService;
import com.example.avalon.utils.ResultVOUtil;
import com.example.avalon.vo.ProductInfoVO;
import com.example.avalon.vo.ProductVO;
import com.example.avalon.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private IProductInfoService productInfoService;

    @Autowired
    private IProductCategoryService productCategoryService;

    @GetMapping("/list")
//    @Cacheable(cacheNames = "product", key = "123")
    public ResultVO getAllUpProductInfoList() {

        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        List<Integer> categoryTypeList = new ArrayList<>();

        for (ProductInfo info : productInfoList) {
            categoryTypeList.add(info.getCategoryType());
        }

        List<ProductCategory> productCategoryList =
                productCategoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }


}