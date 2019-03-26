package com.zhiyou100.dao;

import com.zhiyou100.model.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 11:24
 */
public interface DepartmentDao {
   public List<Department> listDePart() throws SQLException;

   public Department findById(int departmentId) throws SQLException;

   public boolean update(Department d);

   public boolean save(Department d);

   public boolean deleteById(int departmentId);

   public List<Department> selectDown() throws SQLException;
}
