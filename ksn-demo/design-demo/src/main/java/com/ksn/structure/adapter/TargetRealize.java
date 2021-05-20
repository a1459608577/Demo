package com.ksn.structure.adapter;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 9:53
 */
public class TargetRealize implements TwoWayTarget{

    //目标实现
    @Override
    public void request() {
        System.out.println("目标代码被调用！");
    }
}
