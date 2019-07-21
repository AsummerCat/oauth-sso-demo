package com.linjingc.authorizationdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 用户基本操作
 */
@RestController
public class UserController {
    @Autowired
    private TokenStore tokenStore;

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/user")
    public Principal user(Principal user) {
        System.out.println("获取到用户" + user.getName());
        return user;
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
