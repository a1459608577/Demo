package com.ksn.structure.decorator;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 10:11
 */
public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        enhance();
    }

    private void enhance() {
        System.out.println("增强方法");
    }


    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        concreteComponent.operation();
        System.out.println("---------------------------");
        ConcreteDecorator decorator = new ConcreteDecorator(concreteComponent);
        decorator.operation();
    }
}
