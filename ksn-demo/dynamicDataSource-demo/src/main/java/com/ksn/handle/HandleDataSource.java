package com.ksn.handle;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 16:05
 */
public class HandleDataSource {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void putKey(String key) {
        threadLocal.set(key);
    }

    public static String getKey() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
