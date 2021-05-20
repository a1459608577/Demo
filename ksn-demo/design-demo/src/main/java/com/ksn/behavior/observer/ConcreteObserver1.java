package com.ksn.behavior.observer;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 14:04
 */
public class ConcreteObserver1 implements Observer{
    @Override
    public void response() {
        System.out.println("具体观察者1 响应");
    }
}
