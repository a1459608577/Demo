package com.ksn.create.factorymethod;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/17 17:22
 */
public class SimpleFactory {

    public static void main(String[] args) {
        Product product = SimpleFactory.getProduct();
        product.show();
    }


    interface Product {
        void show();
    }

    static class Product1 implements Product {

        @Override
        public void show() {
            System.out.println("产品1显示show");
        }
    }

    public static Product getProduct() {
        return new Product1();
    }

}
