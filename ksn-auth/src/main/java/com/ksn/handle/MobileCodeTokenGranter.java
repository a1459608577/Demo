package com.ksn.handle;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/2 16:45
 */
public class MobileCodeTokenGranter extends AbstractTokenGranter {

    private static final String GRANT_TYPE = "mobile";

    private final AuthenticationManager authenticationManager;


    public MobileCodeTokenGranter( AuthenticationManager authenticationManager, AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService,
                                  OAuth2RequestFactory requestFactory) {
        this(authenticationManager, tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
    }

    protected MobileCodeTokenGranter(AuthenticationManager authenticationManager, AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService,
                                     OAuth2RequestFactory requestFactory, String grantType) {
        super(tokenServices, clientDetailsService, requestFactory, grantType);
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> parameters = new LinkedHashMap<String, String>(tokenRequest.getRequestParameters());
        String username = parameters.get("username");
        String password = parameters.get("password");
        // Protect from downstream leaks of password
        parameters.remove("password");

        Authentication userAuth = new UsernamePasswordAuthenticationToken(username, password);
        ((AbstractAuthenticationToken) userAuth).setDetails(parameters);
        try {
            userAuth = authenticationManager.authenticate(userAuth);
        }
        catch (AccountStatusException ase) {
            //covers expired, locked, disabled cases (mentioned in section 5.2, draft 31)
            throw new InvalidGrantException(ase.getMessage());
        }
        catch (BadCredentialsException e) {
            // If the username/password are wrong the spec says we should send 400/invalid grant
            throw new InvalidGrantException(e.getMessage());
        }
        if (userAuth == null || !userAuth.isAuthenticated()) {
            throw new InvalidGrantException("Could not authenticate user: " + username);
        }

        OAuth2Request storedOAuth2Request = getRequestFactory().createOAuth2Request(client, tokenRequest);
        return new OAuth2Authentication(storedOAuth2Request, userAuth);
//        LinkedHashMap<String, String> map = new LinkedHashMap<>(tokenRequest.getRequestParameters());
//        if (CollUtil.isNotEmpty(map)) {
//            throw new AgileException("参数有误");
//        }
//        String mobile = map.get("mobile");
//        String code = map.get("code");
//        // 验证mobile 和 code
//        if (StrUtil.isEmpty(mobile) || StrUtil.isEmpty(code)) {
//            throw new AgileException("参数有误");
//        }
//
//        Authentication token = new UsernamePasswordAuthenticationToken(mobile, code);
//        ((AbstractAuthenticationToken) token).setDetails(map);
//
//        try {
//            token = authenticationManager.authenticate(token);
//        }
//        catch (AccountStatusException ase) {
//            //covers expired, locked, disabled cases (mentioned in section 5.2, draft 31)
//            throw new InvalidGrantException(ase.getMessage());
//        }
//        catch (BadCredentialsException e) {
//            // If the username/password are wrong the spec says we should send 400/invalid grant
//            throw new InvalidGrantException(e.getMessage());
//        }
//        if (token == null || !token.isAuthenticated()) {
//            throw new InvalidGrantException("Could not authenticate mobile: " + mobile);
//        }
//
//        OAuth2Request storedOAuth2Request = getRequestFactory().createOAuth2Request(client, tokenRequest);
//        return new OAuth2Authentication(storedOAuth2Request, token);
    }
}
