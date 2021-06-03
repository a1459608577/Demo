package com.ksn.handle;

import base.ExceptionStatus;
import base.WebResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 23:08
 */
@Slf4j
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        WebResponse webResponse = new WebResponse(ExceptionStatus.UNAUTHORIZED.value(), "未登录用户鉴权失败，没有权限", e.getClass().getSimpleName());
        httpServletResponse.getWriter().write(JSONUtil.toJsonStr(webResponse));
        log.error("Authenticate Failed!Exception Log:", e);
    }
}
