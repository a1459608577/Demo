package com.ksn.service;

import com.ksn.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/11 14:26
 */
public interface UserService {

    /**
     * h获取user
     * @param id
     * @return
     */
    Mono<User> getUserById(String id);


    /**
     * 获取全部user
     * @return
     */
    Flux<User> getAll();

    /**
     * 保存user
     * @param user
     * @return
     */
    Mono<Void> save(Mono<User> user);
}
