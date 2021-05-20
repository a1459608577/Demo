package com.ksn.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 14:04
 */
public abstract class Subject {

    protected  List<Observer> list = new ArrayList<>();

    public void add(Observer observer) {
        list.add(observer);
    }

    public void remove(Observer observer) {
        list.remove(observer);
    }

    /**
     * 通知方法
     */
    public abstract void notifyObserver();

}
