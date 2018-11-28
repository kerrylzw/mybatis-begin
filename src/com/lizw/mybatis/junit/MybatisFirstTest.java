package com.lizw.mybatis.junit;

import com.lizw.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


/**
 * @author Kerry
 * @date 2018/11/28
 */
public class MybatisFirstTest {
    @Test
    public void findUserById() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql语句
        User user = sqlSession.selectOne("test.findUserById", 10);
        System.out.println(user);
    }

    @Test
    public void findUserByUsername() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql语句
        List<User> users = sqlSession.selectList("test.findUserByUsername", "五");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql语句
        User user = new User();
        user.setUsername("何炅");
        user.setBirthday(new Date());
        user.setAddress("湖南长沙");
        user.setSex("男");
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();

        System.out.println(user.getId());
    }

    @Test
    public void updateUserById() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql语句
        User user = new User();
        user.setId(28);
        user.setUsername("谢娜");
        user.setBirthday(new Date());
        user.setAddress("北京");
        user.setSex("女");
        sqlSession.update("test.updateUserById", user);
        sqlSession.commit();
    }

    @Test
    public void deleteUserById() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql语句
        sqlSession.delete("test.deleteUserById", 28);
        sqlSession.commit();
    }
}
