package com.qingbo.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),

    ORDER_NOT_EXIST(20,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(21, "订单明细不存在"),
    ORDER_STATUS_ERROR(22,"订单状态非法"),
    ORDER_UPDATE_FAIL(23,"订单更新失败"),
    ORDER_PAY_STATUS_ERROR(24,"订单支付状态异常"),

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERR(11,"库存不正确")

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
