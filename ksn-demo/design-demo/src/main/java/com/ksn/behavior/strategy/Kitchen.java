package com.ksn.behavior.strategy;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/20 11:01
 */
public class Kitchen {

    private CrabCooking cooking;

    public Kitchen(CrabCooking cooking) {
        this.cooking = cooking;
    }

    public void CookingMethod() {
        cooking.cooking();
    }

    public static void main(String[] args) {
        SteamedCrabs steamedCrabs = new SteamedCrabs();
        Kitchen kitchen = new Kitchen(steamedCrabs);
        kitchen.CookingMethod();
    }
}
