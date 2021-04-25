package com.ksn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 15:34
 */

@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "com.ksn.dao")
public class UserApp { //extends SpringBootServletInitializer {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(UserApp.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }
}
