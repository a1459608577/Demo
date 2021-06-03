package com.ksn;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/3 12:42
 */
public class ExchangerTest {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static final Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {

        executorService.execute(() -> {
            try {
                String A = "银行流水100";
                String B = exchanger.exchange(A);
                System.out.println("A的视角：A和B数据是否一致：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                String B = "银行流水200";
                String A = exchanger.exchange(B);
                System.out.println("B的视角：A和B数据是否一致：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
