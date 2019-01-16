package com.example.avalon.service;

import com.example.avalon.dto.OrderDTO;

public interface IBuyerService {

    /**
     * 查询指定openid和订单id
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOneOrder(String openid, Integer orderId);

    /**
     * 取消指定订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, Integer orderId);
}
