package com.linjingc.logindemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security配置类
 *
 * @author cxc
 * @date 2019年7月11日16:38:56
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                //开启路径不需要权限访问
                .antMatchers("/login", "/doLogin").permitAll()
                //其他路径都需要权限
                .anyRequest().authenticated();
    }


    /**
     * 放行静态资源
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/images/**");
        web.ignoring().antMatchers("/login/**");
        //解决服务注册url被拦截的问题
        web.ignoring().antMatchers("/resources/**");
    }
}