package com.ksn.controller;

import com.ksn.entity.User;
import com.ksn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/11 14:40
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/get/{id}")
    public Mono<User> getUser(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/get")
    public Flux<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping("/save")
    public Mono<Void> getUser(@RequestBody User user) {
        return userService.save(Mono.just(user));
    }
}
