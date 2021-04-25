package com.ksn.controller;

import com.ksn.entity.annotation.SwitchDataSource;
import com.ksn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 15:34
 */
@RestController
@RequestMapping("/data/source")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test1")
    @SwitchDataSource(key = SwitchDataSource.keyEnum.MASTER)
    public String test1() {
        userService.add();
        return "success1";
    }

    @GetMapping("/test2")
    @SwitchDataSource(key = SwitchDataSource.keyEnum.SLAVE1)
    public String test2() {
        userService.add();
        return "success2";
    }

    @GetMapping("/test3")
    @SwitchDataSource(key = SwitchDataSource.keyEnum.SLAVE2)
    public String test3() {
        userService.add();
        return "success3";
    }
}
