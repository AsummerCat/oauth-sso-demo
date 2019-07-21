package com.linjingc.resourcedemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MrBird
 */
@RestController
public class UserController {

    @GetMapping("show")
    public String authTest12() {
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


    @GetMapping("auth/test1")
    //@PreAuthorize("hasAuthority('user:add')")
    public String authTest1() {
        return "您拥有'user:add'权限";
    }

    @GetMapping("auth/test2")
    @PreAuthorize("hasAuthority('user:update')")
    public String authTest2() {
        return "您拥有'user:update'权限";
    }
}
