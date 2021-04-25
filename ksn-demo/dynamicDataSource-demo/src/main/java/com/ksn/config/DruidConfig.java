package com.ksn.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.ksn.entity.annotation.SwitchDataSource;
import com.ksn.handle.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 16:41
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave1")
    public DataSource slave1DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave2")
    public DataSource slave2DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DataSource chooseDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(masterDataSource());

        HashMap<Object, Object> map = new HashMap<>();
        map.put(SwitchDataSource.keyEnum.MASTER.getKey(), masterDataSource());
        map.put(SwitchDataSource.keyEnum.SLAVE1.getKey(), slave1DataSource());
        map.put(SwitchDataSource.keyEnum.SLAVE2.getKey(), slave2DataSource());
        dataSource.setTargetDataSources(map);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource作为数据源则不能实现切换
        sessionFactory.setDataSource(chooseDataSource());
        // 扫描Model
        sessionFactory.setTypeAliasesPackage("com.ksn.entity");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 扫描映射文件
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        return sessionFactory.getObject();
    }

//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
//        return new DataSourceTransactionManager(chooseDataSource());
//    }
}
