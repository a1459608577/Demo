package com.ksn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ksn.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/22 15:36
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     *
     * @param id
     * @return
     */
    List<User> selectById(String id);
}
