package com.ksn.behavior.chain;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 11:40
 */
public class Dean extends Leader{
    @Override
    public void handleRequest(int LeaveDays) {
        if (LeaveDays < 15) {
            System.out.println("院长批准您请假" + LeaveDays + "天。");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }

    public static void main(String[] args) {
        // 组装责任链
        ClassAdviser classAdviser = new ClassAdviser();
        DepartmentHead departmentHead = new DepartmentHead();
        Dean dean = new Dean();

        classAdviser.setNext(departmentHead);
        departmentHead.setNext(dean);

        classAdviser.handleRequest(5);
    }
}
