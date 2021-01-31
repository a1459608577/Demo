package com.ksn;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/17 20:26
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class,DataSourceAutoConfiguration.class})
public class LocalDateTimeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalDateTimeDemoApplication.class, args);
    }
}
