package com.linjingc.ssologindemo.controller;

import com.linjingc.ssologindemo.service.OauthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MrBird
 */
@RestController
public class UserController {
    @Autowired
    private OauthServiceImpl oauthService;


    @GetMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
        System.out.println("获取到用户" + user.getName());
        return user;
    }

    @RequestMapping("/redirect")
    public Map getToken(@RequestParam String code) {
        Map<String, String> params = new HashMap<>(8);
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        params.put("client_id", "client_2");
        params.put("client_secret", "secret");
        params.put("redirect_uri", "http://loclhost:8200/redirect");
        Map<String, Object> map = oauthService.postAccessToken(params);
        return map;
    }
}
