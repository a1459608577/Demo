package com.ksn.behavior.observer;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 14:08
 */
public class ConcreteSubject extends Subject{
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");
        for (Observer observer : list) {
            observer.response();
        }
    }

    public static void main(String[] args) {
        ConcreteObserver1 observer1 = new ConcreteObserver1();
        ConcreteObserver2 observer2 = new ConcreteObserver2();
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.add(observer1);
        concreteSubject.add(observer2);
        concreteSubject.notifyObserver();
    }
}
