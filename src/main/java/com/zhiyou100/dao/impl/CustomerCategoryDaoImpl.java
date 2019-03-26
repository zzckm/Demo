package com.zhiyou100.dao.impl;

import com.zhiyou100.dao.CustomerCategoryDao;
import com.zhiyou100.model.CustomerCategory;
import com.zhiyou100.util.DBUtil1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 20:10
 */
public class CustomerCategoryDaoImpl implements CustomerCategoryDao {
    @Override
    public List<CustomerCategory> listCcs() throws SQLException {
        DBUtil1 dbUtil = new DBUtil1();
        List<CustomerCategory> list=new ArrayList<CustomerCategory>();

        String sql="select customer_category_id,customer_category_name,customer_category_desc,update_time,updater from customer_category";
        Object[] objects = {};
        ResultSet select = dbUtil.select(sql, objects);
        while (select.next())
        {
            CustomerCategory r=new CustomerCategory();
            r.setCustomerCategoryId(select.getInt(1));
            r.setCustomerCategoryName(select.getString(2));
            r.setCustomerCategoryDesc(select.getString(3));
            r.setUpdateTime(select.getTimestamp(4));
            r.setUpdater(select.getInt(5));
            list.add(r);
        }

        return list;
    }

    @Override
    public CustomerCategory getById(int customerCategoryId) throws SQLException {
        DBUtil1 dbUtil = new DBUtil1();
        String sql="select customer_category_id,customer_category_name,customer_category_desc,update_time,updater from customer_category where customer_category_id=?";
        Object[] objects = {customerCategoryId};
        ResultSet select = dbUtil.select(sql, objects);
        CustomerCategory c=new CustomerCategory();
        while (select.next())
        {

            c.setCustomerCategoryId(select.getInt(1));
            c.setCustomerCategoryName(select.getString(2));
            c.setCustomerCategoryDesc(select.getString(3));
            c.setUpdateTime(select.getTimestamp(4));
            c.setUpdater(select.getInt(5));

        }
        return c;
    }

    @Override
    public boolean update(CustomerCategory cc) {
        DBUtil1 dbUtil = new DBUtil1();
        String sql="update customer_category set customer_category_name=?,customer_category_desc=?,update_time=?,updater=? where customer_category_id=? ";
        Object[] objects={cc.getCustomerCategoryName(),cc.getCustomerCategoryDesc(),cc.getUpdateTime(),cc.getUpdater(),cc.getCustomerCategoryId()};
        int a=0;
        a=dbUtil.update(sql,objects);
        if(a>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean save(CustomerCategory cc) {
        DBUtil1 dbUtil = new DBUtil1();
        String sql="Insert into customer_category(customer_category_name,customer_category_desc,create_time,creater) values(?,?,?,?)";
        Object[] objects={cc.getCustomerCategoryName(),cc.getCustomerCategoryDesc(),cc.getCreateTime(),cc.getCreater()};
        int a=0;
        a=dbUtil.update(sql,objects);
        if(a>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int sourceId) {
        DBUtil1 dbUtil = new DBUtil1();
        String sql="delete from customer_category where customer_category_id=?";
        Object[] objects={sourceId};
        int a=0;
        a=dbUtil.update(sql,objects);
        if(a>0){
            return true;
        }
        return false;
    }
}
