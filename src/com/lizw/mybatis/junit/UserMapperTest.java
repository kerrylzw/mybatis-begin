package com.lizw.mybatis.junit;

import com.lizw.mybatis.mapper.OrderMapper;
import com.lizw.mybatis.mapper.UserMapper;
import com.lizw.mybatis.pojo.QueryVo;
import com.lizw.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Kerry
 * @date 2018/11/29
 */
public class UserMapperTest {
    @Test
    public void findUserById() throws Exception {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(10);
        System.out.println(user);
    }

    @Test
    public void findUserByQueryVo() throws Exception {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("五");
        vo.setUser(user);
        List<User> us = userMapper.findUserByQueryVo(vo);
        for (User u : us) {
            System.out.println(u);
        }
    }

    @Test
    public void countUser() throws Exception {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer num = userMapper.countUser();
        System.out.println(num);
    }

    @Test
    public void selectUserBySexAndUsername() throws Exception {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setSex("1");
        u.setUsername("张小明");
        List<User> users = mapper.selectUserBySexAndUsername(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void selectUserByIds() throws Exception {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(16);
        ids.add(22);
        ids.add(24);
        QueryVo vo = new QueryVo();
        vo.setIdList(ids);
        List<User> users = mapper.selectUserByIds(ids);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void selectUserList() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<User> users = mapper.selectUserList();
        for (User user : users) {
            System.out.println(user);
        }
    }



}