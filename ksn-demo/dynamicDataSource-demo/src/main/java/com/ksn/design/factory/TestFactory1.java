package com.ksn.design.factory;

import com.ksn.design.filter.TestFilter;
import com.ksn.design.handle.FilterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 9:57
 */
@Component
public class TestFactory1 implements TestFactory{

    @Autowired
    private FilterManager filterManager;

    @Override
    public TestFilter getFilter(String id) {
        // 处理逻辑
        return filterManager.getTestFilter(id);
    }
}
