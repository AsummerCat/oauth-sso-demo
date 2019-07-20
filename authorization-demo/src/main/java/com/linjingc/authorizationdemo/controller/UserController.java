package com.linjingc.authorizationdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 用户基本操作
 */
@Controller
@RequestMapping("/oauth")
public class UserController {

    @RequestMapping("getUserInfo")
    public Principal getUserInfo(Principal principal){
        System.out.println("获取到用户"+principal.getName());
        return principal;
    }
}
