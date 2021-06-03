package entity.auth;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/5/26 9:18
 */
@Data
@TableName("t_role")
public class Role implements Serializable {

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("name")
    private String name;

    @TableField("nameZh")
    private String nameZh;
}
