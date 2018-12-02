package com.lizw.mybatis.mapper;

import com.lizw.mybatis.pojo.QueryVo;
import com.lizw.mybatis.pojo.User;

import java.util.List;

/**
 * @author Kerry
 * @date 2018/11/29
 */
public interface UserMapper {

    User findUserById(Integer id);
    List<User> findUserByQueryVo(QueryVo vo);

    /**
     * 查询数据条数
     * @return
     */
    Integer countUser();

    /**
     * 根据性别和名字查询用户
     * @param user
     * @return
     */
    List<User> selectUserBySexAndUsername(User user);

    /**
     * 根据多个id查询用户信息
     * @param ids
     * @return
     */
    List<User> selectUserByIds(Integer[] ids);
    List<User> selectUserByIds(List<Integer> ids);
    List<User> selectUserByIds(QueryVo vo);

}
