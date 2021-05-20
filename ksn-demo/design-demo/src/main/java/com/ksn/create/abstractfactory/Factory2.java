package com.ksn.create.abstractfactory;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/17 17:54
 */
public class Factory2 implements AbstractFactory{

    @Override
    public Product getFactory() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new Product2();
    }
}
