package com.ksn.create.singleton;

/**
 * 单例模式
 * @author ksn
 * @version 1.0
 * @date 2021/5/17 14:49
 */
public class LazySingleton {

    private static volatile LazySingleton singleton = null;

    /**
     * private 避免类在外部被实例化 J就不能在外部new LazySingleton()来创建对象了
     */
    private LazySingleton() {

    }

    /**
     * 懒汉式,多线程下可能会不安全，所以加synchronized， 和volatile
     */
    public static synchronized LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
