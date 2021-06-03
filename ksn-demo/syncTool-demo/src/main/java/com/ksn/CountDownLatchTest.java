package com.ksn;

import cn.hutool.core.date.DatePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/3 10:14
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一号选手准备就绪：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_MS_PATTERN)));
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("二号选手准备就绪：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_MS_PATTERN)));
            countDownLatch.countDown();
        }).start();

        System.out.println("请一号和二号选手准备");
        countDownLatch.await();
        System.out.println("一号和二号选手准备就绪，裁判发枪：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_MS_PATTERN)));
    }
}
