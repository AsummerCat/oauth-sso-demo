//package com.linjingc.ssologindemo.config;
//
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.servlet.http.HttpServletResponse;
//
//@Configuration
//@EnableOAuth2Sso
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
////        http.anyRequest().authenticated();
////                authorizeRequests()
////                // 必须登录过的用户才可以进行 oauth2 的授权码申请
////                //不需要权限访问
////                .antMatchers("/**.html", "/**.html", "/**.css", "/img/**", "/**.js",  "/login","/redirect").permitAll()
////                .anyRequest().authenticated();
//    }
//}