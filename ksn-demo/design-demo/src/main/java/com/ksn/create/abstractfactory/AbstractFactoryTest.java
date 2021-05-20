package com.ksn.create.abstractfactory;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/17 17:55
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        Factory1 factory1 = new Factory1();
        Product factory = factory1.getFactory();
        factory.show();
    }
}
