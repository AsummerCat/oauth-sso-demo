package com.linjingc.ssologindemo.controller;

import com.linjingc.ssologindemo.service.OauthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    private OauthServiceImpl oauthService;

    @GetMapping("/info")
    public String info() {
        return "info";
    }

    @GetMapping("/user")
    public Authentication user(Authentication user) {
        return user;
    }


    /**
     * password模式手动请求token
     * @param code
     * @return
     */
    @RequestMapping("/redirect")
    public Map getToken(@RequestParam String code) {
        Map<String, String> params = new HashMap<>(8);
        params.put("grant_type", "password");
        params.put("client_id", "client_2");
        params.put("client_secret", "secret");
        params.put("username", "583188551");
        params.put("password", "123456");
        //        params.put("code", code);
//        params.put("redirect_uri", "http://loclhost:8200/redirect");
        Map<String, Object> map = oauthService.postAccessToken(params);
        return map;
    }
}
