package com.ksn.service;

import base.AgileException;
import cn.hutool.core.util.StrUtil;
import com.ksn.mapper.CustomizeUserDetailsMapper;
import entity.auth.CustomizeUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 22:11
 */
@Component
@Slf4j
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomizeUserDetailsMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StrUtil.isEmpty(username)) {
            throw new AgileException("用户名不存在");
        }

        CustomizeUserDetails customizeUserDetails = mapper.selectByName(username);
        if (customizeUserDetails == null) {
            throw new AgileException("用户名或密码不正确");
        }
        return customizeUserDetails;
    }
}
