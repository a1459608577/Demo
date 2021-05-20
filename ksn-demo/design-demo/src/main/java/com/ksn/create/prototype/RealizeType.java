package com.ksn.create.prototype;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/17 15:13
 */
public class RealizeType implements Cloneable{

    RealizeType() {
        System.out.println("具体原型创建成功！");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (RealizeType) super.clone();
    }
}
