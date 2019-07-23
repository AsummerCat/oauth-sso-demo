package com.linjingc.logindemo.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("OAUTHSERVER")
public interface OauthService {

    @PostMapping("/oauth/token")
    public Map<String, Object> postAccessToken(@RequestParam Map<String, String> parameters);
}
