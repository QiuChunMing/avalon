package com.example.avalon.service.imp;

import com.example.avalon.dto.OrderDTO;
import com.example.avalon.enums.ResultEnum;
import com.example.avalon.exception.SellException;
import com.example.avalon.service.IBuyerService;
import com.example.avalon.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements IBuyerService {
    @Autowired
    private IOrderService orderService;

    @Override
    public OrderDTO findOneOrder(String openid, Integer orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到改订单, orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    @Override
    public OrderDTO cancelOrder(String openid, Integer orderId) {
        return checkOrderOwner(openid, orderId);
    }
    /**
     * 检查订单是否属于该用户
     * @param openid
     * @param orderId
     * @return OrderDTO
     */
    private OrderDTO checkOrderOwner(String openid, Integer orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致. openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
