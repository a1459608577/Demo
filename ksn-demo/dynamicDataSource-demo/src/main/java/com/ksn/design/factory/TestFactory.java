package com.ksn.design.factory;

import com.ksn.design.filter.TestFilter;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 9:52
 */
public interface TestFactory {

    /**
     *  获取filter
     * @param id
     * @return
     */
    TestFilter getFilter(String id);
}
