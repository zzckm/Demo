package com.zhiyou100.service.impl;

import com.zhiyou100.dao.DepartmentDao;
import com.zhiyou100.model.Department;
import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.util.SqlSessionNew;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 11:24
 */
public class DepartmentServiceImpl implements DepartmentService {
    SqlSessionNew sqlSession=new SqlSessionNew();
    DepartmentDao departmentDao=sqlSession.getSqlSession().getMapper(DepartmentDao.class);
    @Override
    public List<Department> listDePart() throws SQLException {
        List<Department> list;
        list= departmentDao.listDePart();
        sqlSession.subimt();
        return list;
    }

    @Override
    public Department findById(int departmentId) throws SQLException {
        Department u=departmentDao.findById(departmentId);
        sqlSession.subimt();
        return u;
    }

    @Override
        public boolean update(Department d) {
        boolean a=departmentDao.update(d);
        sqlSession.subimt();
        return a;
    }

    @Override
    public boolean save(Department d) {
        boolean a=departmentDao.save(d);
        sqlSession.subimt();
        return a;
    }

    @Override
    public boolean deleteById(int departmentId) {
        boolean a=departmentDao.deleteById(departmentId);
        sqlSession.subimt();
        return a;
    }

    @Override
    public List<Department> selectDown() throws SQLException {
        List<Department> list=departmentDao.selectDown();
        sqlSession.subimt();
        return list;
    }
}
