package com.linjingc.authorizationdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * 用户基本操作
 */
@Controller
public class UserController {
    @Autowired
    private TokenStore tokenStore;

    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping("getUserInfo")
    @ResponseBody
    public Authentication getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("获取到用户" + authentication.getName());
        return authentication;
    }
    @RequestMapping("getUserInfo1")
    @ResponseBody
    public Object getUserInfo1(Principal principal) {
        System.out.println("获取到用户" + principal.getName());
        return principal;
    }

    /**
     * 删除token
     *
     * @param principal
     * @param access_token
     */
    @RequestMapping("removeToken")
    public void removeToken(Principal principal, String access_token) {
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(access_token);
        if (oAuth2AccessToken != null) {
            //移除access_token
            tokenStore.removeAccessToken(oAuth2AccessToken);
            //移除refresh_token
            tokenStore.removeRefreshToken(oAuth2AccessToken.getRefreshToken());
        }
    }

}
