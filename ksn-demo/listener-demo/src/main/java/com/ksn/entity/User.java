package com.ksn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 15:37
 */
@Data
@ApiModel("用户对象")
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 2670921234332033575L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    @ApiModelProperty("主键")
    private String id;
    @TableField("age")
    @ApiModelProperty("年龄")
    private Integer age;
    @TableField("password")
    @ApiModelProperty("密码")
    private String password;
    @TableField("sex")
    @ApiModelProperty("性别")
    private String sex;
    @TableField("username")
    @ApiModelProperty("用户名")
    private String username;
}
