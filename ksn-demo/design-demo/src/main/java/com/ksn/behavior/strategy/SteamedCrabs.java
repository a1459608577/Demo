package com.ksn.behavior.strategy;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 10:55
 */
public class SteamedCrabs implements CrabCooking{
    @Override
    public void cooking() {
        System.out.println("清蒸大闸蟹");
    }
}
