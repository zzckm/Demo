package com.zhiyou100.dao.impl;

import com.zhiyou100.dao.CustomerSourceDao;
import com.zhiyou100.model.CustomerSource;
import com.zhiyou100.util.DBUtil1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/26 21:47
 */
public class CustomerSourceDaoImpl implements CustomerSourceDao {
    @Override
    public List<CustomerSource> listCcs() throws SQLException {
        DBUtil1 dbUtil = new DBUtil1();
        List<CustomerSource> list=new ArrayList<CustomerSource>();

        String sql="select customer_source_id,customer_source_name,customer_source_desc,update_time,updater from customer_source";
        Object[] objects = {};
        ResultSet select = dbUtil.select(sql, objects);
        while (select.next())
        {
            CustomerSource r=new CustomerSource();
            r.setCustomerSourceId(select.getInt(1));
            r.setCustomerSourceName(select.getString(2));
            r.setCustomerSourceDesc(select.getString(3));
            r.setUpdateTime(select.getTimestamp(4));
            r.setUpdater(select.getInt(5));
            list.add(r);
        }

        return list;
    }

    @Override
    public boolean save(CustomerSource cc) {
        DBUtil1 dbUtil = new DBUtil1();
        String sql="Insert into customer_source(customer_source_name,customer_source_desc,create_time,creater) values(?,?,?,?)";
        Object[] objects={cc.getCustomerSourceName(),cc.getCustomerSourceDesc(),cc.getCreateTime(),cc.getCreater()};
        System.out.println("sqlsqsqssq");
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
        String sql="delete from customer_source where customer_source_id=?";
        Object[] objects={sourceId};
        //System.out.println("sqlsqsqssq");
        int a=0;
        a=dbUtil.update(sql,objects);
        if(a>0){
            return true;
        }
        return false;
    }

    @Override
    public CustomerSource getById(int customerSourceId) throws SQLException {
        CustomerSource c=new CustomerSource();
        DBUtil1 dbUtil = new DBUtil1();
        String sql="select customer_source_id,customer_source_name,customer_source_desc,update_time,updater from customer_source where customer_source_id=?";
        System.out.println(customerSourceId+"lll");
        Object[] objects = {customerSourceId};
        ResultSet select = dbUtil.select(sql, objects);
        while (select.next())
        {
            c.setCustomerSourceId(select.getInt(1));
            c.setCustomerSourceName(select.getString(2));
            c.setCustomerSourceDesc(select.getString(3));
            c.setUpdateTime(select.getTimestamp(4));
            c.setUpdater(select.getInt(5));
            System.out.println(c);

        }
        return c;
    }

    @Override
    public boolean update(CustomerSource cc) {
        System.out.println(cc);
        DBUtil1 dbUtil = new DBUtil1();
        String sql="update customer_source set customer_source_name=?,customer_source_desc=?,update_time=?,updater=? where customer_source_id=? ";
        Object[] objects={cc.getCustomerSourceName(),cc.getCustomerSourceDesc(),cc.getUpdateTime(),cc.getUpdater(),cc.getCustomerSourceId()};
        //System.out.println(objects);
        int a=0;
        a=dbUtil.update(sql,objects);
        if(a>0){
            return true;
        }
        return false;
    }


}
