package com.ksn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/9 18:22
 */
@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("test01")
    public String test() {
        redisTemplate.opsForValue().set("ksn", "ksn");
        return "success";
    }
}
