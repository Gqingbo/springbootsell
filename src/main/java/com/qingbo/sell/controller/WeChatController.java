package com.qingbo.sell.controller;

import com.qingbo.sell.enums.ResultEnum;
import com.qingbo.sell.exception.OrderException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/12/19 13:33
 * @Description:
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WeChatController {
    @Autowired
    private WxMpService wxMpService;
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl")String returnUrl){
        //1配置
        //2调用方法
        String url = "http://localhost:8080/sell/wechat/userInfo";
        String response = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(returnUrl));
        RestTemplate restTemplate = new RestTemplate();
        log.info("[微信网页授权] 获取code，result={}",response);

        return "redirect:"+response;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code")String code,
                              @RequestParam("state")String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken ;
        try {
            wxMpOAuth2AccessToken= wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            e.printStackTrace();
            log.error("[微信网页授权]{}",e);
            throw new OrderException(ResultEnum.WeChart_Mp_ERROR.getCode(),e.getError().getErrorMsg());
        }

        String openId = wxMpOAuth2AccessToken.getOpenId();
        return "redirect:"+returnUrl+"?openid="+openId;
    }

}
