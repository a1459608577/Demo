package com.ksn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.auth.CustomizeUserDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 22:12
 */
@Mapper
public interface CustomizeUserDetailsMapper extends BaseMapper<CustomizeUserDetails> {

    /**
     * 根据名字查询用户
     * @param username
     * @return
     */
    CustomizeUserDetails selectByName(String username);
}
