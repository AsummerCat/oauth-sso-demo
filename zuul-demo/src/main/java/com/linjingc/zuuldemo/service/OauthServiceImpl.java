package com.linjingc.zuuldemo.service;

import javax.annotation.Resource;
import java.util.Map;

public class OauthServiceImpl implements OauthService {
    @Resource
    private OauthService oauthService;
    @Override
    public Map<String, Object> postAccessToken(Map<String, String> parameters) {
        return oauthService.postAccessToken(parameters);
    }
}
