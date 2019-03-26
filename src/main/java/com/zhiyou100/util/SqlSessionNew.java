package com.zhiyou100.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: 张峥
 * @Date: 2019/3/7 12:21
 */
public class SqlSessionNew {
    //加载核心配置文件
    private SqlSession sqlSession;
    public SqlSession getSqlSession(){
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-cfg.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = factory.openSession();
        return  sqlSession;
    }
    public void subimt(){
        sqlSession.commit();
        sqlSession.clearCache();
    }

}
