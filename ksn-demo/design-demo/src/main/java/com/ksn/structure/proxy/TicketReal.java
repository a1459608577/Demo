package com.ksn.structure.proxy;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/19 17:16
 */
public class TicketReal implements TicketSubject{

    /**
     * 火车站 真正卖票的地方
     */
    @Override
    public void Ticketing() {
        System.out.println("真实买票的地方。。。");
    }
}
