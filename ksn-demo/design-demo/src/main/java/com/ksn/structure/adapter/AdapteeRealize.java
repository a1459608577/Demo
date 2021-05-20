package com.ksn.structure.adapter;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 9:53
 */
public class AdapteeRealize implements TwoWayAdaptee{

    //适配者实现
    @Override
    public void specificRequest() {
        System.out.println("适配者代码被调用！");
    }
}
