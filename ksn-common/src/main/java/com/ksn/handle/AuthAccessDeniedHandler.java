package com.ksn.handle;

import base.WebResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 22:55
 */
@Slf4j
@Component
public class AuthAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        WebResponse webResponse = new WebResponse(200, "鉴权失败，已经登录的用户权限不足", e.getClass().getSimpleName());
        httpServletResponse.getWriter().write(JSONUtil.toJsonStr(webResponse));
        log.error("Visit 【{}】 Access Denied!Exception Log:",httpServletRequest.getRequestURL().toString(),e);

    }
}
