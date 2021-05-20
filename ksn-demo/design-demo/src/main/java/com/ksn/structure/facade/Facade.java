package com.ksn.structure.facade;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 10:20
 */
public class Facade {

    private SubSystem01 sub1 = new SubSystem01();
    private SubSystem02 sub2 = new SubSystem02();


    public void advisor() {
        sub1.subSystem01();
        sub2.subSystem02();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.advisor();
    }
}
