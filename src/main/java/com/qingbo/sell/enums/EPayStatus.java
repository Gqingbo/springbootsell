package com.qingbo.sell.enums;

import lombok.Getter;

@Getter
public enum EPayStatus {
    WAITING(0,"待支付"),
    SUCCESS(1,"已支付");

    private Integer code;
    private String codeName;

    EPayStatus(Integer code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }
}
