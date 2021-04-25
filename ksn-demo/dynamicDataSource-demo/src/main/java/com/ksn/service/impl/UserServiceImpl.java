package com.ksn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ksn.entity.User;
import com.ksn.mapper.UserMapper;
import com.ksn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 15:35
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void add() {
        User user = new User();
        user.setAge(200);
        user.setUsername("lisi");
        user.setPassword("123456");
        user.setSex("1");
        List<User> users = userMapper.selectById("2");
        System.out.println(users);
        userMapper.insert(user);
    }
}
