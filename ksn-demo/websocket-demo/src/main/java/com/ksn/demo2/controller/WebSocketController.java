package com.ksn.demo2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/2/2 17:50
 */
@Slf4j
@Controller
@RequestMapping("test")
public class WebSocketController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/socket3")
    public ModelAndView socket() {
        ModelAndView mav = new ModelAndView("/socket3");
        return mav;
    };

    @GetMapping("/socket4")
    public ModelAndView socket4() {
        ModelAndView mav = new ModelAndView("/socket4");
        return mav;
    };
    @GetMapping("/login")
    public ModelAndView socket5() {
        ModelAndView mav = new ModelAndView("/login");
        return mav;
    };
}
