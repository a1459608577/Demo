package com.ksn.create.singleton;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/17 14:57
 */
public class HungrySingleton {

    private static volatile HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return singleton;
    }
}
