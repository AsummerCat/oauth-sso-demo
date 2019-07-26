package com.linjingc.resourcedemo.config;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableResourceServer
public abstract class ResServerConfig extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);

//        resources.authenticationEntryPoint(new LLGAuthenticationEntryPoint());

    }
}
