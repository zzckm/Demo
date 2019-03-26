package com.zhiyou100.service.impl;

import com.zhiyou100.dao.CustomerCategoryDao;
import com.zhiyou100.dao.impl.CustomerCategoryDaoImpl;
import com.zhiyou100.model.CustomerCategory;
import com.zhiyou100.service.CustomerCategoryService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 20:09
 */
public class CustomerCategoryServiceImpl implements CustomerCategoryService {
    List<CustomerCategory> list;
    CustomerCategoryDao ccd;
    @Override
    public List<CustomerCategory> listCcs() throws SQLException {
        list=new ArrayList<CustomerCategory>();
        ccd=new CustomerCategoryDaoImpl();
        list=ccd.listCcs();
        return list;
    }

    @Override
    public CustomerCategory getById(int customerCategoryId) throws SQLException {
        ccd=new CustomerCategoryDaoImpl();
        CustomerCategory cc=new CustomerCategory();
        cc=ccd.getById(customerCategoryId);
        return cc;
    }

    @Override
    public boolean update(CustomerCategory cc) {
        ccd=new CustomerCategoryDaoImpl();
        boolean isUpdate=ccd.update(cc);
        return isUpdate;
    }

    @Override
    public boolean save(CustomerCategory r) {
        ccd=new CustomerCategoryDaoImpl();
        boolean isSave=ccd.save(r);
        return isSave;
    }

    @Override
    public boolean deleteById(int sourceId) {
        ccd=new CustomerCategoryDaoImpl();
        boolean isDelete=ccd.deleteById(sourceId);
        return isDelete;
    }
}
