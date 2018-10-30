package com.qingbo.sell.enums;

import lombok.Getter;

/**
 * 商品上下架状态
 */
@Getter
public enum EProductStatus {
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;
    private String name;

    EProductStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
