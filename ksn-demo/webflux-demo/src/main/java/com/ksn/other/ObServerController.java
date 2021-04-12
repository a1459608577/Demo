package com.ksn.other;

import lombok.SneakyThrows;

import java.util.Observable;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/10 22:13
 */
public class ObServerController extends Observable {

    public static void main(String[] args) {
        ObServerController obServerController = new ObServerController();

        obServerController.addObserver((o, arg) -> {
            System.out.println(o);
            System.out.println(arg);
            System.out.println("观察者模式");
        });
        obServerController.addObserver((o, arg) -> {
            System.out.println(o);
            System.out.println(arg);
            System.out.println("观察观察者模式");
        });

        TreadTest treadTest = new TreadTest();
        Thread thread1 = new Thread(treadTest);
        Thread thread2 = new Thread(treadTest);
        Thread thread3 = new Thread(treadTest);
        thread1.start();
        thread2.start();
        thread3.start();
        // 使数据变化
        obServerController.setChanged();
        // 通知到观察者
        obServerController.notifyObservers();
    }

    static class TreadTest implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "------" + Thread.currentThread().getId() + "----执行了");
            }
        }
    }
}
