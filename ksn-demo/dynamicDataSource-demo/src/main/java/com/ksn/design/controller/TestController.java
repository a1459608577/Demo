package com.ksn.design.controller;

import com.ksn.design.factory.TestFactory;
import com.ksn.design.filter.TestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 10:22
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestFactory testFactory;

    @GetMapping("/design/{id}")
    public String test(@PathVariable("id") String id) {
        TestFilter filter = testFactory.getFilter(id);
        String asdf = filter.test("asdf");
        return asdf;
    }
}
