package com.zhiyou100.service.impl;

import com.zhiyou100.dao.CustomerStateDao;
import com.zhiyou100.dao.impl.CustomerStateDaoImpl;
import com.zhiyou100.model.CustomerState;
import com.zhiyou100.service.CustomerStateService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 21:41
 */
public class CustomerStateServiceImpl implements CustomerStateService {
    List<CustomerState> list;
    CustomerStateDao csd;
    @Override
    public List<CustomerState> listCcs() throws SQLException {
        list=new ArrayList<CustomerState>();
        csd=new CustomerStateDaoImpl();
        list=csd.listCcs();
        return list;
    }

    @Override
    public boolean save(CustomerState r) {
        csd=new CustomerStateDaoImpl();
        boolean isSave=csd.save(r);
        return isSave;
    }

    @Override
    public boolean deleteById(int customerStateId) {
        csd=new CustomerStateDaoImpl();
        boolean isDelete=csd.deleteById(customerStateId);
        return isDelete;
    }

    @Override
    public CustomerState getById(int customerStateId) throws SQLException {
        CustomerState c=new CustomerState();
        csd=new CustomerStateDaoImpl();
        c=csd.getById(customerStateId);
        return c;
    }

    @Override
    public boolean update(CustomerState cc) {
        csd=new CustomerStateDaoImpl();
        boolean isUpdate=csd.update(cc);
        return isUpdate;
    }
}
