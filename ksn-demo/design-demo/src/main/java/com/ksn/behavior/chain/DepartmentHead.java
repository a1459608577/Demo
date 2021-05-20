package com.ksn.behavior.chain;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 11:40
 */
public class DepartmentHead extends Leader{
    @Override
    public void handleRequest(int LeaveDays) {
        if (LeaveDays < 7) {
            System.out.println("系主任批准您请假" + LeaveDays + "天。");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
