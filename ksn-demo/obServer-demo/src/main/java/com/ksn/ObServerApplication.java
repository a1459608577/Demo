package com.ksn;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/10 22:10
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class ObServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObServerApplication.class, args);
    }
}
