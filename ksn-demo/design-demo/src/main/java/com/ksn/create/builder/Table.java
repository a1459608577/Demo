package com.ksn.create.builder;

import lombok.Data;

/**
 * 桌子由木材，螺丝， 胶水组成
 * @author ksn
 * @version 1.0
 * @date 2021/5/19 16:42
 */
@Data
public class Table {
    /**
     * 木材
     */
    private String wood;
    /**
     * 螺丝
     */
    private String screw;
    /**
     * 胶水
     */
    private String glue;

    public void getTable() {
        System.out.println("建造桌子");
    }
}
