package com.ksn.create.abstractfactory;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/17 17:54
 */
public class Factory1 implements AbstractFactory{
    @Override
    public Product getFactory() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new Product1();
    }
}
