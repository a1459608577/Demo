package com.ksn.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/15 9:35
 */
public class ReaderObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        ObServerTest o1 = (ObServerTest) o;
        System.out.println("Observable对象：" + o1.name);
        System.out.println("arg对象：" + arg);

        System.out.println("我是读者， 我已收到更新");
    }
}
