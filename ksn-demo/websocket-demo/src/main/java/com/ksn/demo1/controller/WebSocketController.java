package com.ksn.demo1.controller;

import com.ksn.demo1.service.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/2/2 16:50
 */
@Controller
@RequestMapping("/test")
public class WebSocketController {

    /**
     * 页面请求
     * @param userId
     * @return
     */
    @GetMapping("/socket1/{userId}")
    public ModelAndView socket(@PathVariable String userId) {
        ModelAndView mav = new ModelAndView("/socket1");
        mav.addObject("userId", userId);
        return mav;
    };
    @GetMapping("/socket2/{userId}")
    public ModelAndView socket1(@PathVariable String userId) {
        ModelAndView mav = new ModelAndView("/socket2");
        mav.addObject("userId", userId);
        return mav;
    };

    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public Map pushToWeb(@PathVariable("cid") String cid, String message) throws IOException {
        HashMap<Object, Object> map = new HashMap<>();
        WebSocketServer.sendInfo(message, cid);
        map.put("code", 200);
        map.put("msg", "success");
        return map;
    }
}
