package com.ksn;

import java.util.concurrent.Semaphore;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/3 11:28
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        // 5辆车
        int count = 5;
        // 7个停车位
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < count; i++) {
            new CarThread(i, semaphore).start();
        }
    }

    static class CarThread extends Thread {
        private int i;
        private Semaphore semaphore;

        public CarThread(int i, Semaphore semaphore) {
            this.i = i;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {

                semaphore.acquire();
                System.out.println("车辆" + i + "占用一个车位");
                Thread.sleep(3000);
                System.out.println("车辆" + i + "离开车位");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
