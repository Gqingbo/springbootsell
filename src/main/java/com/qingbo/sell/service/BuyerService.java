package com.qingbo.sell.service;

import com.qingbo.sell.dto.OrderDTO;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/12/18 20:55
 * @Description:
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openId,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openId,String orderId);
}
