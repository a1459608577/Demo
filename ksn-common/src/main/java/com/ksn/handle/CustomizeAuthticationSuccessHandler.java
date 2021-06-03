package com.ksn.handle;

import base.AgileException;
import base.ExceptionStatus;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 23:15
 */
@Slf4j
@Component
public class CustomizeAuthticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws ServletException, IOException {
        String authInfo=httpServletRequest.getHeader("Authorization");

        if (StrUtil.isBlank(authInfo)){
            throw new AgileException(ExceptionStatus.AUTHENTICATION_IS_EMPTY);
        }

        super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
    }

    @Override
    public void setRequestCache(RequestCache requestCache) {
        super.setRequestCache(requestCache);
    }
}
