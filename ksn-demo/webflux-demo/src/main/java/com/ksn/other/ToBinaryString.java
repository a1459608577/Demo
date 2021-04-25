package com.ksn.other;


import org.apache.commons.lang.StringUtils;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/11 14:00
 */
public class ToBinaryString {

    public static void main(String[] args) {
        int n = 4;
        int n1 = 1;
        String s = Integer.toBinaryString(n);
        System.out.println(n + "的二进制值为：" +  s);
        int a = n >>> n1;
        System.out.println(n + "向左位移" + n1 + "后的数值为：" +  a);
        String s1 = Integer.toBinaryString(a);
        System.out.println(a + "的二进制值为：" +  s1);
        System.out.println(Integer.valueOf(StringUtils.rightPad(s, s.length() + n1, "0"), 2).toString());
    }
}
