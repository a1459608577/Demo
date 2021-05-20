package com.ksn.create.builder;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/19 16:49
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 组装桌子
     */
    public void putUp() {
        builder.getGlue();
        builder.getWood();
        builder.getScrew();
        Table table = builder.getTable();
        table.getTable();
        System.out.println("开始建造");
    }

    /**
     * 客户端调用
     * @param args
     */
    public static void main(String[] args) {
        Builder builder = new TableBuilder();
        Director director = new Director(builder);
        director.putUp();
    }
}
