package com.linjingc.zuuldemo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;


/**
 * 手动注入spring
 * setAuthenticationSuccessHandler
 *
 * @author cxc
 */
@Component
public class DefaultRolesPrefixPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof FilterChainProxy) {

            FilterChainProxy chains = (FilterChainProxy) bean;

            for (SecurityFilterChain chain : chains.getFilterChains()) {
                for (Filter filter : chain.getFilters()) {
                    if (filter instanceof OAuth2ClientAuthenticationProcessingFilter) {
                        OAuth2ClientAuthenticationProcessingFilter oAuth2ClientAuthenticationProcessingFilter = (OAuth2ClientAuthenticationProcessingFilter) filter;
                        oAuth2ClientAuthenticationProcessingFilter.setAuthenticationSuccessHandler(new MyAuthenticationSuccessHandler());
                    }
                }
            }
        }
        return bean;
    }
}