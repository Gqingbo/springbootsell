package com.qingbo.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: gaoqingbo
 * @Date: 2018/12/18 21:32
 * @Description:
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    private static final String APPID="";
    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        //授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理，以get的方式，传入code
        log.info("进入auth方法...");
        log.info("code={}",code);//code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret=SECRET&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}",response);
    }

    /**
     * 授权前：需要给公众号绑定一个外网可以访问的域名
     *
     * 微信网页授权：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
     * 第一步：用户同意授权，获取code
     *    https://open.weixin.qq.com/connect/oauth2/authorize?
     *    appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
     *    若提示“该链接无法访问”，请检查参数是否填写错误，是否拥有scope参数对应的授权作用域权限。
     *    如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
     *
     * 第二步：通过code换取网页授权access_token
     *   获取code后，请求以下链接获取access_token：
     *   https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
     *
     * 第三步：刷新access_token（如果需要）
     *   获取第二步的refresh_token后，请求以下链接获取access_token：
     *   https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
     *
     * 第四步：拉取用户信息(需scope为 snsapi_userinfo)
     *   http：GET（请使用https协议） https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
     *
     */
}
