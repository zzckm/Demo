package com.zhiyou100.service.impl;

import com.zhiyou100.dao.UserDao;

import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;
import com.zhiyou100.util.SqlSessionNew;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/25 15:16
 */
public class UserServiceImpl implements UserService {
    SqlSessionNew sqlSession=new SqlSessionNew();
    UserDao userDao=sqlSession.getSqlSession().getMapper(UserDao.class);
    @Override
    public User login(User u) throws SQLException, IOException {
        User uu=userDao.login(u);
        System.out.println("用户名密码 ："+uu);
        sqlSession.subimt();
        return uu;
    }

    @Override
    public List<User> searchByKeyWord(String searchField, String keyword) throws SQLException, IOException {
        List<User> list;
        User u=new User();
        if(keyword!=""||!keyword.equals("")) {
            if (searchField.equals("username")) {
                u.setUsername("username");
            } else if (searchField.equals("mobile")) {
                u.setMobile("mobile");
            } else if (searchField.equals("address")) {
                u.setAddress("address");
            }
            u.setKeyword("%" + keyword + "%");
        }
        list= userDao.searchByKeyWord(u);
        sqlSession.subimt();

        return list;
    }

    @Override
    public boolean save(User r) {
        System.out.println(r);
        boolean a=userDao.save(r);
        sqlSession.subimt();
        System.out.println(a);
        return a;
    }


    @Override
    public User findById(Integer userId) throws SQLException {
        User u=userDao.findById(userId);
        sqlSession.subimt();
        return u;
    }

    @Override
    public boolean update(User r) {
        boolean a=userDao.update(r);
        sqlSession.subimt();
        return a;
    }

    @Override
    public boolean deleteById(Integer userId) {
        boolean a=userDao.deleteById(userId);
        sqlSession.subimt();
        return a;
    }
//下拉框
    @Override
    public List<User> selectDown() throws SQLException {
        List<User> list=userDao.selectDown();
        sqlSession.subimt();
        return list;
    }
}
