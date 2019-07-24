package com.linjingc.zuuldemo.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
@Order(3)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
//        http.authorizeRequests().antMatchers( "/2/**", "/","/1/**")
//                .permitAll().anyRequest().authenticated();
//        http.authorizeRequests()
//                //不需要权限访问
//                .antMatchers("/**.html", "/**.html", "/**.css", "/img/**", "/**.js", "/ssoLoginServer/login","/oauthServer/**","/").permitAll()
//                .anyRequest().authenticated();
    }
}