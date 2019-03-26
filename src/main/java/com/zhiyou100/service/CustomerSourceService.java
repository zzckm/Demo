package com.zhiyou100.service;

import com.zhiyou100.model.CustomerSource;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 21:39
 */
public interface CustomerSourceService {
   public List<CustomerSource> listCcs() throws SQLException;


  public boolean save(CustomerSource r);

   public boolean deleteById(int sourceId);

   public CustomerSource getById(int customerSourceId) throws SQLException;

   public boolean update(CustomerSource cc);

    // public boolean update(CustomerCategory cc);
}
