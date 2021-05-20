package com.ksn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 14:16
 */
@SpringBootApplication
@EnableAsync
public class ListenerApp {

    public static void main(String[] args) {
        SpringApplication.run(ListenerApp.class, args);
    }
}
