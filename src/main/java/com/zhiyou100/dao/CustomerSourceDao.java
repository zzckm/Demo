package com.zhiyou100.dao;

import com.zhiyou100.model.CustomerSource;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 21:46
 */
public interface CustomerSourceDao {
   public List<CustomerSource> listCcs() throws SQLException;

   public boolean save(CustomerSource r);

   public boolean deleteById(int sourceId);

   public CustomerSource getById(int customerSourceId) throws SQLException;


   public boolean update(CustomerSource cc);
}
