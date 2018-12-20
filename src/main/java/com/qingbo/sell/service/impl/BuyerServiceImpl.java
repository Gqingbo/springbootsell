package com.qingbo.sell.service.impl;

import com.qingbo.sell.dto.OrderDTO;
import com.qingbo.sell.enums.ResultEnum;
import com.qingbo.sell.exception.OrderException;
import com.qingbo.sell.service.BuyerService;
import com.qingbo.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/12/18 20:57
 * @Description:
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {

        return checkOpenId(openId, orderId);
    }



    @Override
    public OrderDTO cancelOrder(String openId, String orderId) {
        OrderDTO orderDTO = checkOpenId(openId, orderId);
        if (orderDTO == null) {
         log.error("[取消订单] 查不到订单，orderID={},openId={}",orderId,openId);
        }
        return orderService.cancel(orderDTO);
    }
    /**
     * 检查openID是否符合
     * @param orderId
     * @param openId
     */
    private OrderDTO checkOpenId(String openId, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openId)){
            log.error("[查询订单] 订单的openid不一致，openID={},orderDTO={}",openId,orderDTO);
            throw new OrderException(ResultEnum.ORDER_OPENID_ERROR);
        }
        return orderDTO;
    }
}
