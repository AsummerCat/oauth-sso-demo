package com.linjingc.zuuldemo.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.csrf().disable();
        http.authorizeRequests()
                //不需要权限访问
                .antMatchers("/**.html", "/**.html", "/**.css", "/img/**", "/**.js", "/ssoLoginServer/login","/oauthServer/**","/").permitAll()
                .anyRequest().authenticated();
    }
}