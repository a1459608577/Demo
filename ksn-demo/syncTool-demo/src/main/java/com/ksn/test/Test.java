package com.ksn.test;

import java.util.ArrayList;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/3 9:37
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(test1());
    }

    public static String test1() throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();

        long l = System.currentTimeMillis();

        for (int i = 0; i < 3000; i++) {
            String x = "执行" + i;
            list.add(x);
            System.out.println(x);
            Thread.sleep(1L);
        }

        long a = System.currentTimeMillis() - l;
        System.out.println("执行完毕:" + list.size());

        return String.valueOf(a);
    }
}
