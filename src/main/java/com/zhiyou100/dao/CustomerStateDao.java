package com.zhiyou100.dao;

import com.zhiyou100.model.CustomerState;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 21:41
 */
public interface CustomerStateDao {
   public List<CustomerState> listCcs() throws SQLException;

   public boolean save(CustomerState r);

   public boolean deleteById(int customerStateId);

   public CustomerState getById(int customerStateId) throws SQLException;

   public boolean update(CustomerState cc);
}
