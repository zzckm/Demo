package com.zhiyou100.service;

import com.zhiyou100.model.Role;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 14:08
 */
public interface RoleService {
   public List<Role> listRole() throws SQLException;

  public boolean save(Role r);

   public boolean update(Role r);

   public Role findById(int roleId) throws SQLException;

   public boolean deleteById(int roleId);

   public List<Role> selectDown() throws SQLException;
}
