package com.linjingc.logindemo.controller.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("oauthServer")
public interface OauthService {

    @PostMapping("/oauth/token")
    public String authorization();
}
