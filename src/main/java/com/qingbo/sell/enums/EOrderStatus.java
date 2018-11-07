package com.qingbo.sell.enums;

import lombok.Getter;

@Getter
public enum EOrderStatus {
    NEW(0,"新订单"),
    FINISHED(1,"已️完结"),
    CANCEL(2,"取消");

    private Integer code;
    private String codeName;


    EOrderStatus(Integer i, String codeName) {
        this.code =i;
        this.codeName=codeName;
    }
}
