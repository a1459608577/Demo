package com.ksn.config;

import base.AgileException;
import base.WebResponse;
import cn.hutool.core.collection.CollectionUtil;
import com.ksn.filter.CustomClientCredentialsTokenEndpointFilter;
import com.ksn.handle.CustomizeAuthenticationEntryPoint;
import com.ksn.handle.MobileCodeTokenGranter;
import com.ksn.service.AuthClientDetailsService;
import com.ksn.service.AuthUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenGranter;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeTokenGranter;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.implicit.ImplicitTokenGranter;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.refresh.RefreshTokenGranter;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 22:29
 */
@Configuration
@EnableAuthorizationServer
@Slf4j
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private TokenEnhancer tokenEnhancer;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint;
    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    /**
     * 指定 ClientDetailsService 接口对应的 bean 就是真实的 bean
     * @return
     */
    @Bean
    public ClientDetailsService myClientDetailsService() {
        return new AuthClientDetailsService();
    }

    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();

        services.setClientDetailsService(myClientDetailsService());
        services.setTokenStore(tokenStore);
        services.setSupportRefreshToken(true);
        services.setReuseRefreshToken(true);

        TokenEnhancerChain chain = new TokenEnhancerChain();
        chain.setTokenEnhancers(CollectionUtil.newArrayList(tokenEnhancer, jwtAccessTokenConverter));
        services.setTokenEnhancer(chain);

        return services;
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }

    @Bean
    public WebResponseExceptionTranslator exceptionTranslator() {
        return new DefaultWebResponseExceptionTranslator() {
            @Override
            public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
                log.error("Authorization Exception Transform：", e);

                ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
                return new ResponseEntity(new WebResponse(responseEntity.getStatusCode().value(), formatExceptionMsg(e)
                        ,e.getClass().getSimpleName()), responseEntity.getHeaders(), HttpStatus.OK);
            }
        };
    }

    private String formatExceptionMsg(Exception e) {
        if (e instanceof InvalidGrantException) {
            return "用户名或密码不正确";
        } else if (e instanceof AgileException) {
            return e.getMessage();
        }

        //TODO 处理其他异常

        return "Authorization Failed";
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 相当于是开放/oauth/key_token,/oauth/check_token两个端点
        security.tokenKeyAccess("permitAll()");
        security.checkTokenAccess("isAuthenticated()");

        // 配置自定义的过滤器处理，验证client和secret错误
        CustomClientCredentialsTokenEndpointFilter filter = new CustomClientCredentialsTokenEndpointFilter(security);
        filter.afterPropertiesSet();
        filter.setAuthenticationEntryPoint(customizeAuthenticationEntryPoint);
        security.addTokenEndpointAuthenticationFilter(filter);

        // 让/oauth/token支持client_id以及client_secret作登录认证，
//        security.allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(myClientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore)
                .tokenServices(tokenServices())
                .tokenEnhancer(tokenEnhancer)
                .accessTokenConverter(jwtAccessTokenConverter)
                .exceptionTranslator(exceptionTranslator())
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.OPTIONS, HttpMethod.POST)
                // 配置自定义授权模式
                .tokenGranter(tokenGranter1(endpoints));
    }

    private TokenGranter tokenGranter1(AuthorizationServerEndpointsConfigurer  endpoint) {
        ArrayList<TokenGranter> list = new ArrayList<>();

        // 密码模式
        if (authenticationManager != null) {
            list.add(new ResourceOwnerPasswordTokenGranter(authenticationManager,
                    endpoint.getTokenServices(),
                    endpoint.getClientDetailsService(),
                    endpoint.getOAuth2RequestFactory()));
        }
        // 刷新token模式
        list.add(new RefreshTokenGranter(endpoint.getTokenServices()
                ,endpoint.getClientDetailsService()
                ,endpoint.getOAuth2RequestFactory()));
        // 自定义手机号模式
        list.add(new MobileCodeTokenGranter(authenticationManager
                ,endpoint.getTokenServices()
                ,endpoint.getClientDetailsService()
                ,endpoint.getOAuth2RequestFactory()
                ,authUserDetailsService));
        // 授权码模式
        list.add(new AuthorizationCodeTokenGranter(endpoint.getTokenServices()
                ,endpoint.getAuthorizationCodeServices()
                ,endpoint.getClientDetailsService()
                ,endpoint.getOAuth2RequestFactory()));
        // 简化模式
        list.add(new ImplicitTokenGranter(endpoint.getTokenServices()
                ,endpoint.getClientDetailsService()
                ,endpoint.getOAuth2RequestFactory()));
        // 客户端模式
        list.add(new ClientCredentialsTokenGranter(endpoint.getTokenServices()
                ,endpoint.getClientDetailsService()
                ,endpoint.getOAuth2RequestFactory()));

        return new CompositeTokenGranter(list);
    }

    public static void main(String[] args) {
        // 0010
        // 0101
        // 0000
        int a = 2 & 5;
        System.out.println(a);
    }
}
