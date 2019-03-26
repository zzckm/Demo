package com.zhiyou100.dao;

import com.zhiyou100.model.CustomerCategory;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 20:10
 */
public interface CustomerCategoryDao {
   public List<CustomerCategory> listCcs() throws SQLException;

   public CustomerCategory getById(int customerCategoryId) throws SQLException;

   public boolean update(CustomerCategory cc);

  public boolean save(CustomerCategory r);

   public boolean deleteById(int sourceId);
}
