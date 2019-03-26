package com.zhiyou100.service;

import com.zhiyou100.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/25 15:16
 */
public interface UserService {
   public User login(User user) throws SQLException, IOException;

   public List<User> searchByKeyWord(String searchField, String keyword) throws SQLException, IOException;

   public boolean save(User r);

   public User findById(Integer userId) throws SQLException;

   public boolean update(User r);

   public boolean deleteById(Integer userId);

   public List<User> selectDown() throws SQLException;
}
