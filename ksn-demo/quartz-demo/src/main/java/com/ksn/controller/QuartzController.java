package com.ksn.controller;

import com.ksn.service.QuartzService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/30 20:45
 */
@RestController
public class QuartzController {

    @Autowired
    QuartzService quartzService;

    @GetMapping("test")
    public String test() throws SchedulerException {
        quartzService.test();
        return "string";
    }
}
