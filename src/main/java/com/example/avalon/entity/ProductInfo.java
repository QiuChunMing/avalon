package com.example.avalon.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
//@Entity
public class ProductInfo {
/*    JDBC
    最新JDBC映射将把数据库的日期类型和Java 8的新类型关联起来：
    SQL -> Java
--------------------------
    date -> LocalDate
    time -> LocalTime
    timestamp -> LocalDateTime*/

    @Id
    @GeneratedValue
    private String productId;
    private String productName;
    private double productPrice;
    private int productStack;
    private String productDescription;
    /*商品图标*/
    private String productIcon;
    /*商品类目*/
    private String categoryType;
    /*创建时间*/
    private Date createTime;
    /*修改时间*/
    private Date updateTime;


}
