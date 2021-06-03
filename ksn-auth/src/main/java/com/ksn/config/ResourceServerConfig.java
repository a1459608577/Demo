package com.ksn.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 23:01
 */
@Configuration
@EnableResourceServer
@Slf4j
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AuthenticationEntryPoint authorizationEndpoint;
    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("res1").tokenStore(tokenStore);
        resources.accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(authorizationEndpoint);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin().successHandler(successHandler).failureHandler(failureHandler)
                .usernameParameter("an").passwordParameter("ap");

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(authorizationEndpoint);

        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().and().csrf().disable();

        http.authorizeRequests().anyRequest().authenticated();
    }
}
