package com.ksn.structure.decorator;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 10:09
 */
public class Decorator implements Component{

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        if (component == null) {
            component = new ConcreteComponent();
        }
        component.operation();
    }
}
