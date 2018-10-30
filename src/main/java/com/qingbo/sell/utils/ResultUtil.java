package com.qingbo.sell.utils;


import VO.ResultVO;

public class ResultUtil {
    public static ResultVO<Object> success(Object o) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(o);
        return resultVO;
    }
}
