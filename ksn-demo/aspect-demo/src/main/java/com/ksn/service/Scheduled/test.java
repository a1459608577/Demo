package com.ksn.service.Scheduled;

import cn.hutool.core.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/2/22 11:56
 */
public class test {
    private static final Logger log = LoggerFactory.getLogger(test.class);
    public static final List<String> list = new ArrayList<>(Arrays.asList("1", "2"));
    public static final String a = "asdf";


    public static void main(String[] args) {
        log.info("asdf");
        String[] strings = {"/**/v2/api-docs", "/test/**/11", "/11/22/**"};
        boolean whiteList = test.getWhiteList(strings, "/v2/api-docs");
        System.out.println(whiteList);
    }
    public static boolean getWhiteList(String[] ignoreUrlList, String url) {
        if (ArrayUtil.isNotEmpty(ignoreUrlList)) {
            for (int j = 0; j < ignoreUrlList.length; j++) {
                boolean flag = true;
                String[] urls = url.split("/");
                String[] items = ignoreUrlList[j].split("/");
                for (int i = 1; i < (urls.length < items.length ? urls.length : items.length); i++) {
                    if (("**").equals(items[i])) {
                        if (i == 1 && urls.length == 2 && items.length != 2) {
                            flag = false;
                        }
                        continue;
                    }
                    if (!items[i].equals(urls[i])) {
                        flag = false;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
