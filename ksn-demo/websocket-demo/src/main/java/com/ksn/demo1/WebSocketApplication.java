package com.ksn.demo1;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/31 16:28
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class WebSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }
}
