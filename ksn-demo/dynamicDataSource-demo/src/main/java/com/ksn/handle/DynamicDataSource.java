package com.ksn.handle;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 15:41
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 如果不希望数据源在启动配置时就加载好，可以定制这个方法，从任何你希望的地方读取并返回数据源
     * 比如从数据库、文件、外部接口等读取数据源信息，并最终返回一个DataSource实现类对象即可
     */
    @Override
    protected DataSource determineTargetDataSource() {
        return super.determineTargetDataSource();
    }

    /**
     * 如果希望所有数据源在启动配置时就加载好，这里通过设置数据源Key值来切换数据，定制这个方法
     * 切换数据源的方法，获取数据源名称
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return HandleDataSource.getKey();
    }
}
