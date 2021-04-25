package com.ksn.entity.annotation;

import java.lang.annotation.*;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 15:50
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Target(value = ElementType.METHOD)
public @interface SwitchDataSource {

    keyEnum key() default keyEnum.MASTER;

    enum keyEnum {
        /**
         * 数据源
         */
        MASTER("master"),
        SLAVE1("slave1"),
        SLAVE2("slave2");

        private String key;

        keyEnum(String key) {
            this.key = key;
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
