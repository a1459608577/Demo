package com.ksn.design.handle;

import com.ksn.design.filter.TestFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 9:58
 */
public class FilterManager {

    public Map map = new HashMap<String, TestFilter>();

    public TestFilter getTestFilter(String id) {
        return (TestFilter) map.get(id);
    }

}
