package com.zhiyou100.mapper;

import com.zhiyou100.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/25 15:18
 */
public interface UserMapper {
    public User login(User user) throws SQLException, IOException;

    public  List<User> searchByKeyWord(User user) throws SQLException;
    public  List<User> searchByKeyWordNull() throws SQLException;

   public boolean save(User r);

   public User findById(int userId) throws SQLException;

   public boolean update(User r);

   public boolean deleteById(int userId);

   public List<User> selectDown() throws SQLException;
}
