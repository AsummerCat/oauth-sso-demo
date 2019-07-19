package com.linjingc.logindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public String doLogin(String username,String password) {

        return "login";
    }

}
