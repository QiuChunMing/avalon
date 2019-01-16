package com.example.avalon.entity;

import com.example.avalon.enums.OrderStatusEnum;
import com.example.avalon.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class OrderMaster {
    @Id
    @GeneratedValue
    private Integer orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    /**
     * 买家微信openId
     */
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态，默认为0新下单
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /**
     * 支付状态，默认为0等待支付
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

}
