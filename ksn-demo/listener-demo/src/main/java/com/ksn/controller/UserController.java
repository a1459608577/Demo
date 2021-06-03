package com.ksn.controller;

import com.ksn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 15:37
 */
@RestController
@RequestMapping("listener")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        String test = userService.test();
        return test;
    }

    @GetMapping("/test1")
    public String test1() {
        return "test";
    }
}
