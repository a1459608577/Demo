package com.ksn.create.builder;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/19 16:45
 */
public abstract class Builder {

    private Table table = new Table();

    public abstract void getWood();

    public abstract void getScrew();

    public abstract void getGlue();

    /**
     * 返回桌子对象
     */
    public Table getTable() {
        return table;
    }

}
