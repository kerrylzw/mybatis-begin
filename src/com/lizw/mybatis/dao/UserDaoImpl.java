package com.lizw.mybatis.dao;

import com.lizw.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Kerry
 * @date 2018/11/29
 */
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User selectUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("test.findUserById", id);
    }
}
