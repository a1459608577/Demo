package com.ksn;

import java.util.concurrent.CyclicBarrier;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/3 10:57
 */
public class CyclicBarrierTest {
    static int countA = 1;
    static int countB = 1;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            System.out.println("两个选手都跑完一圈，开始新的一圈");
        });

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("一号选手第" + countA++ + "圈");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("一号选手到达终点");
                try {
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("二号选手第" + countB++ + "圈");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("二号选手到达终点");
                try {
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
