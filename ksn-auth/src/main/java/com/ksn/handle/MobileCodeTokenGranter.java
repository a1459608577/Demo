package com.ksn.handle;

import base.AgileException;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.ksn.service.AuthUserDetailsService;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.LinkedHashMap;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/2 16:45
 */
public class MobileCodeTokenGranter extends AbstractTokenGranter {

    private static final String GRANT_TYPE = "mobile";

    private final AuthenticationManager authenticationManager;

    private AuthUserDetailsService authUserDetailsService;

    public MobileCodeTokenGranter( AuthenticationManager authenticationManager, AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService,
                                  OAuth2RequestFactory requestFactory, AuthUserDetailsService authUserDetailsService) {
        this(authenticationManager, tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
        this.authUserDetailsService = authUserDetailsService;
    }

    protected MobileCodeTokenGranter(AuthenticationManager authenticationManager, AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService,
                                     OAuth2RequestFactory requestFactory, String grantType) {
        super(tokenServices, clientDetailsService, requestFactory, grantType);
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        // 主要做两件事：1. 做验证，验证传过来的手机号和验证码 2. 构造授权账户
        LinkedHashMap<String, String> map = new LinkedHashMap<>(tokenRequest.getRequestParameters());
        if (CollUtil.isEmpty(map)) {
            throw new AgileException("参数有误");
        }
        String mobile = map.get("mobile");
        String code = map.get("code");
        String username = map.get("username");
        // 验证mobile 和 code
        String phoneCode = "1234";
        if (StrUtil.isEmpty(mobile) || StrUtil.isEmpty(code) || !phoneCode.equals(code)) {
            throw new AgileException("参数有误");
        }

        // 按理来说在这里要有一个通过手机号查询用户信息的方法，这里用用户名代替
        UserDetails userDetails = authUserDetailsService.loadUserByUsername(username);

        //构造授权账号
        Authentication token = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword()
                ,userDetails.getAuthorities());
        ((AbstractAuthenticationToken) token).setDetails(token);

        OAuth2Request storedOAuth2Request = getRequestFactory().createOAuth2Request(client, tokenRequest);
        return new OAuth2Authentication(storedOAuth2Request, token);
    }
}
