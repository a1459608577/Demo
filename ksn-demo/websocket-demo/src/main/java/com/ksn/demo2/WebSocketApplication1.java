package com.ksn.demo2;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/31 16:28
 */
@SpringBootApplication
public class WebSocketApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication1.class, args);
    }
}
