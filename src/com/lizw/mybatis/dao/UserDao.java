package com.lizw.mybatis.dao;

import com.lizw.mybatis.pojo.User;

/**
 * @author Kerry
 * @date 2018/11/29
 */
public interface UserDao {
    User selectUserById(Integer id);
}
