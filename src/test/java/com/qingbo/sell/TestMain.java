package com.qingbo.sell;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/12/10 10:30
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("aaa",1);
        //13482807779
        //15921485758
        Integer aaa = map.get("aaa");
        System.out.println(map.get("aaa"));
    }
}

