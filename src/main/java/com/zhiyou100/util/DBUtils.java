package com.zhiyou100.util;

import java.sql.*;

public class DBUtils {
    final static String driver = "com.mysql.jdbc.Driver";
    final static String url = "jdbc:mysql:///xc?characterEncoding=utf8";
    final static String user = "root";
    final static String password = "123456";
    static Connection con=null;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }


    public static void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
