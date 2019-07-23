package com.linjingc.authorizationdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登录
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "进入认证服务器";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
