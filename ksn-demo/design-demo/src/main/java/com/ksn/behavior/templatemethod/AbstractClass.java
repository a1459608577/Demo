package com.ksn.behavior.templatemethod;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 10:36
 */
public abstract class AbstractClass {

    public void method() {
        abstract1();
        abstract2();
    }

    public abstract void abstract1();

    public abstract void abstract2();
}
