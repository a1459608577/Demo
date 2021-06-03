package com.ksn.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.auth.AuthClientDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 15:43
 */
@Mapper
public interface AuthClientDetailsMapper extends BaseMapper<AuthClientDetails> {

    AuthClientDetails loadClientDetailsByClientId(String clientId);
}
