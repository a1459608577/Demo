package com.ksn.observer;

import java.util.Observable;

/**
 * 模拟公众号文章推送，观察目标是栈长我，观察者是你们大家，我发布一篇文章，你们都能接收到更新通知并能阅读。
 *
 * @author ksn
 * @version 1.0
 * @date 2021/4/15 9:13
 */
public class ObServerTest extends Observable {

    public String name;

    public void publish(String msg) {
        // 发布文章
        this.name = msg;
        System.out.println("发布文章：" + msg);

        // 改变状态
        this.setChanged();

        // 通知观察者们
        this.notifyObservers("hahahhaha");
    }

    public static void main(String[] args) {
        ObServerTest obServerTest = new ObServerTest();
        ReaderObserver readerObserver = new ReaderObserver();

        // 加 到观察者列表
        obServerTest.addObserver(readerObserver);

        // 发布更新
        obServerTest.publish("a文章");
    }
}
