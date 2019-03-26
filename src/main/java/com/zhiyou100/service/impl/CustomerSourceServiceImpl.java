package com.zhiyou100.service.impl;

import com.zhiyou100.dao.CustomerSourceDao;
import com.zhiyou100.dao.impl.CustomerSourceDaoImpl;
import com.zhiyou100.model.CustomerSource;
import com.zhiyou100.service.CustomerSourceService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 21:40
 */
public class CustomerSourceServiceImpl implements CustomerSourceService {
    List<CustomerSource> list;
    CustomerSourceDao csd;
    @Override
    public List<CustomerSource> listCcs() throws SQLException {
        list=new ArrayList<CustomerSource>();
        csd=new CustomerSourceDaoImpl();
        list=csd.listCcs();
        return list;
    }

    @Override
    public boolean save(CustomerSource r) {
        csd=new CustomerSourceDaoImpl();
        boolean isSave=csd.save(r);
        return isSave;
    }

    @Override
    public boolean deleteById(int sourceId) {
        csd=new CustomerSourceDaoImpl();
        boolean isDelete=csd.deleteById(sourceId);
        return isDelete;
    }

    @Override
    public CustomerSource getById(int customerSourceId) throws SQLException {
        CustomerSource cs=new CustomerSource();
        csd=new CustomerSourceDaoImpl();
        cs=csd.getById(customerSourceId);
        return cs;
    }

    @Override
    public boolean update(CustomerSource cc) {
        csd=new CustomerSourceDaoImpl();
        boolean isUpdate=csd.update(cc);
        return isUpdate;
    }

/*    @Override
    public boolean update(CustomerCategory cc) {
        csd=new CustomerSourceDaoImpl();
        boolean isUpdate=csd.update(cc);
        return isUpdate;
    }*/


}
