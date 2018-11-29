package com.lizw.mybatis.mapper;

import com.lizw.mybatis.pojo.User;

/**
 * @author Kerry
 * @date 2018/11/29
 */
public interface UserMapper {

    User findUserById(Integer id);
}
