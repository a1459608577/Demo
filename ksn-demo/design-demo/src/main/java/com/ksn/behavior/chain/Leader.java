package com.ksn.behavior.chain;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 11:26
 */
public abstract class Leader {

    private Leader next;

    public Leader getNext() {
        return this.next;
    }

    public void setNext(Leader next) {
        this.next = next;
    }

    public abstract void handleRequest(int LeaveDays);

}
