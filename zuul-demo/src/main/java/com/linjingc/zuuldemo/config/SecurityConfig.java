package com.linjingc.zuuldemo.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //@Autowired
    //private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.csrf().disable();
        http.authorizeRequests()
                //不需要权限访问
                .antMatchers("/**.html", "/**.html", "/**.css", "/img/**", "/**.js", "/").permitAll()
                .anyRequest().authenticated()
                .and();

                //.and().formLogin().successHandler(new MyAuthenticationSuccessHandler());


        //@Bean
        //SimpleUrlAuthenticationFailureHandler failureHandler(){
        //    return new SimpleUrlAuthenticationFailureHandler(failureUrl);
        //}
    }

    //@Bean
    //SimpleUrlAuthenticationSuccessHandler successHandler(){
    //
    //    return new SimpleUrlAuthenticationSuccessHandler("/hello");
    //}
}