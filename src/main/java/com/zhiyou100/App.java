package com.zhiyou100;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args ) throws IOException {
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
      /*  InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        List<User> objects = sqlSession.selectList("com.zhiyou100.mapper.userMapper.find");
        System.out.println(objects.size());
        for (User user:objects
             ) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();*/

    }
}
