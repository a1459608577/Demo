package com.ksn.design.config;

import cn.hutool.core.collection.CollUtil;
import com.ksn.design.filter.TestFilter;
import com.ksn.design.handle.FilterManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 9:51
 */
@Slf4j
@Configuration
public class TestConfig {

    @Autowired
    private List<TestFilter> testFilters;

    @Bean
    public FilterManager filterManager() {
        FilterManager manager = new FilterManager();
        if (CollUtil.isNotEmpty(testFilters)) {
            testFilters.stream().forEach(item -> {
                manager.map.put(item.getClass().getSimpleName(), item);
            });
        }
        return manager;
    }
}
