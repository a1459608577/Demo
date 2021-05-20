package com.ksn.design.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 9:47
 */
@Slf4j
@Component
public class TestFilter2 implements TestFilter {

    @Override
    public String test(String id) {
        return "TestFilter2---" + id;
    }
}
