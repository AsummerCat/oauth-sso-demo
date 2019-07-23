package com.linjingc.zuuldemo.controller;

import com.linjingc.zuuldemo.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MrBird
 */
@RestController
public class UserController {
@Autowired
private OauthService oauthService;

    @GetMapping("/")
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

    @RequestMapping("/aiqiyi/qq/redirect")
    public Map getToken(@RequestParam String code) {
        Map<String, String> params = new HashMap<>(8);
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        params.put("client_id", "client_2");
        params.put("client_secret", "secret");
        params.put("redirect_uri", "http://localhost:8700/redirect");
         Map<String, Object> map = oauthService.postAccessToken(params);
        return map;
    }
}
