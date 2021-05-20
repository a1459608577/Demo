package com.ksn.structure.decorator;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 10:09
 */
public class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println("具体的组件");
    }
}
