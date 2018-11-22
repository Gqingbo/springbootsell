package com.qingbo.sell.utils;

import com.qingbo.sell.enums.CodeEnum;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/11/7 17:41
 * @Description:
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
