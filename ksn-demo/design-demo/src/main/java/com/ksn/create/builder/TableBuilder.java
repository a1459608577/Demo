package com.ksn.create.builder;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/19 16:47
 */
public class TableBuilder extends Builder{

    @Override
    public void getWood() {
        System.out.println("获取木材");
    }

    @Override
    public void getScrew() {
        System.out.println("获取螺丝");
    }

    @Override
    public void getGlue() {
        System.out.println("获取胶水");
    }
}
