package com.ksn.service.impl;

import com.ksn.entity.User;
import com.ksn.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/11 14:28
 */
@Service
public class UserServiceImpl implements UserService {

    private final Map map = new HashMap<String, Object>();

    public UserServiceImpl() {
        map.put("1", new User(1, "zhangsan", new Date()));
        map.put("2", new User(2, "lisi", new Date()));
        map.put("3", new User(3, "王五", null));
    }


    @Override
    public Mono<User> getUserById(String id) {
        User o = (User) map.get(id);
        return Mono.just(o);
    }

    @Override
    public Flux<User> getAll() {
        return Flux.fromIterable(this.map.values());
    }

    @Override
    public Mono<Void> save(Mono<User> user) {
        return user.doOnNext(person -> {
            map.put(map.size() + 1, new User(map.size() + 1, person.getName(), new Date()));
        }).thenEmpty(Mono.empty());
    }
}
