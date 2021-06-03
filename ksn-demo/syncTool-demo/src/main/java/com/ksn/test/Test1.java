package com.ksn.test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/3 9:37
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(test1());
    }

    public static String test1() throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        CountDownLatch count = new CountDownLatch(3);

        long l = System.currentTimeMillis();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                String x = "执行" + i;
                list.add(x);
                System.out.println(x);
            }
            count.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                String x = "执行" + i;
                list.add(x);
                System.out.println(x);
            }
            count.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                String x = "执行" + i;
                list.add(x);
                System.out.println(x);
            }
            count.countDown();
        }).start();

        count.await();
        long a = System.currentTimeMillis() - l;

        System.out.println("执行完毕:" + list.size());

        return String.valueOf(a);
    }
}
