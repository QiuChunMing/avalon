package com.example.avalon.service;

import com.example.avalon.dto.CartDTO;
import com.example.avalon.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductInfoService {
    ProductInfo findOne(Integer productId);

    /**
     * 查询所有上架的商品信息列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有商品信息列表
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);


    /**
     * 保存商品信息
     *
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     */
    void increaseStock(List<CartDTO> cartDTOList);


    /**
     * 减库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);


    /**
     * 上架
     *
     * @param productId
     * @return
     */
    ProductInfo onSale(Integer productId);

    /**
     * 下架
     *
     * @param productId
     * @return
     */
    ProductInfo offSale(Integer productId);
}
