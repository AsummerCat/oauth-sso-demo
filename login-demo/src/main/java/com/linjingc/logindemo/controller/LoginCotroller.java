package com.linjingc.logindemo.controller;

import com.linjingc.logindemo.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginCotroller {
    @Autowired
    private OauthService oauthService;

    @GetMapping("/login")
    public String index(HttpServletRequest request) {
        return "login";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public Map<String, Object> doLogin(HttpServletRequest request,String username, String password) {

        Map<String, String> parameters = new HashMap<>(8);
        parameters.put("grant_type", request.getHeader("grantType"));
        parameters.put("client_id", request.getHeader("clientId"));
        parameters.put("client_secret", request.getHeader("clientSecret"));
        parameters.put("scope", request.getHeader("scope"));
        parameters.put("username", username);
        parameters.put("password", password);
        Map<String, Object> tokenInfo = oauthService.postAccessToken(parameters);
        return tokenInfo;
    }


}
