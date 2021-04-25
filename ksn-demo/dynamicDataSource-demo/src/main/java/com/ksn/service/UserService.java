package com.ksn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ksn.entity.User;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 15:35
 */
public interface UserService extends IService<User> {
    /**
     *新增数据
     */
    void add();

}
