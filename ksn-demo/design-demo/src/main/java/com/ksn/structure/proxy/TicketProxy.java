package com.ksn.structure.proxy;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/19 17:18
 */
public class TicketProxy implements TicketSubject{
    private TicketReal ticketReal;
    /**
     * 代理卖票的地方，12306
     */
    @Override
    public void Ticketing() {
        if (ticketReal == null) {
            ticketReal = new TicketReal();
        }
        pre();
        ticketReal.Ticketing();
        post();
    }

    private void pre() {
        System.out.println("出票前置处理");
    }

    private void post() {
        System.out.println("出票后置处理");
    }

    public static void main(String[] args) {
        TicketProxy ticketProxy = new TicketProxy();
        ticketProxy.Ticketing();
    }
}
