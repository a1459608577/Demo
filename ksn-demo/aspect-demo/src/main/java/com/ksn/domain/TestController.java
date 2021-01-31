package com.ksn.domain;

import com.ksn.annotation.TestAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/4 17:14
 */

@Slf4j
@EnableAutoConfiguration
@Controller
@Api(value = "test", tags = "测试")
@RequestMapping("/test")
public class TestController {

    @TestAnnotation()
    @ApiOperation("测试1")
    @GetMapping("/test1")
    @ResponseBody
    public String test1(HttpServletResponse response) {
        return "test1";
    }

    @ApiOperation("测试2")
    @GetMapping("/test2")
    @ResponseBody
    public String test2() {
        return "test2";
    }

}
