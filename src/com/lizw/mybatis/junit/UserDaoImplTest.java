package com.lizw.mybatis.junit;

import com.lizw.mybatis.dao.UserDao;
import com.lizw.mybatis.dao.UserDaoImpl;
import com.lizw.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @author Kerry
 * @date 2018/11/29
 */
public class UserDaoImplTest {
    public SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public void selectUserById() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.selectUserById(10);
        System.out.println(user);
    }

}