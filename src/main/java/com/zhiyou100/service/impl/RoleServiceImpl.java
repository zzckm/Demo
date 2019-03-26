package com.zhiyou100.service.impl;

import com.zhiyou100.dao.RoleDao;
import com.zhiyou100.model.Role;
import com.zhiyou100.service.RoleService;
import com.zhiyou100.util.SqlSessionNew;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 14:08
 */
public class RoleServiceImpl implements RoleService {
    SqlSessionNew sqlSession=new SqlSessionNew();
    RoleDao roleDao=sqlSession.getSqlSession().getMapper(RoleDao.class);
    @Override
    public List<Role> listRole() throws SQLException {
        List<Role> list;
        list= roleDao.listRole();
        sqlSession.subimt();
        return list;
    }

    @Override
    public boolean save(Role r) {
        boolean a=roleDao.save(r);
        sqlSession.subimt();
        return a;
    }

    @Override
    public boolean update(Role r) {
        boolean a=roleDao.update(r);
        sqlSession.subimt();
        return a;
    }

    @Override
    public Role findById(int roleId) throws SQLException {
        Role u=roleDao.findById(roleId);
        sqlSession.subimt();
        return u;
    }

    @Override
    public boolean deleteById(int roleId) {
        boolean a=roleDao.deleteById(roleId);
        sqlSession.subimt();
        return a;
    }

    @Override
    public List<Role> selectDown() throws SQLException {
        List<Role> list=roleDao.selectDown();
        sqlSession.subimt();
        return list;
    }
}
