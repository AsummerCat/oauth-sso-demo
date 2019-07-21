package com.linjingc.resourcedemo.utils;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Map;

/**
 * @author cxc
 * @date 2019/7/21 16:28
 */
public class UserUtils {
    /**
     * 获取当前用户
     */
    public static String getLoginAppUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
            authentication = oAuth2Authentication.getUserAuthentication();

            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                UsernamePasswordAuthenticationToken oAuth2AuthenticationToken = (UsernamePasswordAuthenticationToken) authentication;
                Map map = (Map) oAuth2AuthenticationToken.getDetails();
                map = (Map) map.get("principal");
                return map.toString();
            }
        }
        return null;
    }
}
