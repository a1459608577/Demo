package com.ksn.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/28 10:36
 */
@Data
public class TestEntity implements Serializable {

    String code;
    String name;
    String number;
    String remark;
}
