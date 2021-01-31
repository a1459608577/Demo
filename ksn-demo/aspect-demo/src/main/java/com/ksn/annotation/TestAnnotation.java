package com.ksn.annotation;

import java.lang.annotation.*;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/4 17:53
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

    String methodName() default "";
}
