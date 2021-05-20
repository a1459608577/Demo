package com.ksn.create.prototype;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/17 15:15
 */
public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        RealizeType realizeType = new RealizeType();
        RealizeType clone = (RealizeType)realizeType.clone();
        // false
        System.out.println(realizeType == clone);
    }
}
