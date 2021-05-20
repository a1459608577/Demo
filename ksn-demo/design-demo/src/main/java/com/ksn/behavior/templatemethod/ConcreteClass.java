package com.ksn.behavior.templatemethod;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 10:39
 */
public class ConcreteClass extends AbstractClass{
    @Override
    public void abstract1() {
        System.out.println("abstract1具体实现");
    }

    @Override
    public void abstract2() {
        System.out.println("abstract2具体实现");
    }

    public static void main(String[] args) {
        AbstractClass concrete =  new ConcreteClass();
        concrete.method();
    }
}
