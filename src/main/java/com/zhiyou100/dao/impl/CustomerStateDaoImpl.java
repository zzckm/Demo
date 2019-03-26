package com.zhiyou100.dao.impl;

import com.zhiyou100.dao.CustomerStateDao;
import com.zhiyou100.model.CustomerState;
import com.zhiyou100.util.DBUtil1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 21:42
 */
public class CustomerStateDaoImpl implements CustomerStateDao {
    @Override
    public List<CustomerState> listCcs() throws SQLException {
        DBUtil1 dbUtil = new DBUtil1();
        List<CustomerState> list=new ArrayList<CustomerState>();

        String sql="select customer_state_id,customer_state_name,customer_state_desc,update_time,updater from customer_state";
        Object[] objects = {};
        ResultSet select = dbUtil.select(sql, objects);
        while (select.next())
        {
            CustomerState r=new CustomerState();
            r.setCustomerStateId(select.getInt(1));
            r.setCustomerStateName(select.getString(2));
            r.setCustomerStateDesc(select.getString(3));
            r.setUpdateTime(select.getTimestamp(4));
            r.setUpdater(select.getInt(5));
            list.add(r);
        }

        return list;
    }

    @Override
    public boolean save(CustomerState r) {
        DBUtil1 dbUtil = new DBUtil1();
        List<CustomerState> list=new ArrayList<CustomerState>();

        String sql="Insert into customer_state(customer_state_name,customer_state_desc,create_time,creater) values(?,?,?,?) ";
        Object[] objects = {r.getCustomerStateName(),r.getCustomerStateDesc(),r.getCreateTime(),r.getCreater()};
        int a=0;
        a= dbUtil.update(sql, objects);
        if(a>0){
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int customerStateId) {
        DBUtil1 dbUtil = new DBUtil1();
        List<CustomerState> list=new ArrayList<CustomerState>();

        String sql="delete from customer_state where customer_state_id=?";
        Object[] objects = {customerStateId};
        int a=0;
        a= dbUtil.update(sql, objects);
        if(a>0){
            return  true;
        }
        return false;
    }

    @Override
    public CustomerState getById(int customerStateId) throws SQLException {
        CustomerState c=new CustomerState();
        DBUtil1 dbUtil = new DBUtil1();
        String sql="select customer_state_id,customer_state_name,customer_state_desc,update_time,updater from customer_state where customer_state_id=?";
       // System.out.println(customerStateId+"lll");
        Object[] objects = {customerStateId};
        ResultSet select = dbUtil.select(sql, objects);
        while (select.next())
        {
            c.setCustomerStateId(select.getInt(1));
            c.setCustomerStateName(select.getString(2));
            c.setCustomerStateDesc(select.getString(3));
            c.setUpdateTime(select.getTimestamp(4));
            c.setUpdater(select.getInt(5));
            System.out.println(c);

        }
        return c;
    }

    @Override
    public boolean update(CustomerState cc) {
        System.out.println(cc);
        DBUtil1 dbUtil = new DBUtil1();
        String sql="update customer_state set customer_state_name=?,customer_state_desc=?,update_time=?,updater=? where customer_state_id=? ";
        Object[] objects={cc.getCustomerStateName(),cc.getCustomerStateDesc(),cc.getUpdateTime(),cc.getUpdater(),cc.getCustomerStateId()};
        //System.out.println(objects);
        int a=0;
        a=dbUtil.update(sql,objects);
        if(a>0){
            return true;
        }
        return false;
    }
}
