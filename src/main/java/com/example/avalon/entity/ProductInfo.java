package com.example.avalon.entity;

import com.example.avalon.enums.PayStatusEnum;
import com.example.avalon.enums.ProductStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class ProductInfo {

    @Id
    @GeneratedValue
    private Integer productId;

    /**
     * 产品名字
     */
    private BigDecimal productPrice;

    /**
     * 产品库存
     */
    private Integer productStock;

    /**
     * 产品图片
     */
    private String productIcon;
    /**
     * 产品名字
     */
    private String productName;
    /**
     * 产品描述
     */
    private String productDescription;

    /**
     * 状态
     * 0 正常
     * 1 下架
     */
    private Integer productStatus = ProductStatus.UP.getCode();

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private LocalDate createTime = LocalDate.now();

    /**
     * 更新时间
     */
    private LocalDate updateTime;

    public ProductStatus getProductStatus() {
        return EnumUtil.getByCode(productStatus, ProductStatus.class);
    }
}
