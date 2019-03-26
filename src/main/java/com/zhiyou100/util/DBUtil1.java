package com.zhiyou100.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil1 {
	private String url;
	private String user;
	private String password;
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	//加载驱动并且建立连接
	public void getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动加载失败");
		}
		
		
		try {
//			url="jdbc:mysql://localhost:3306/xcx_zhiyou888c?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			url="jdbc:mysql://localhost:3306/xc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8&useSSL=true";
			user="root";
			password="123456";
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//释放资源
	public void close(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	//查询的方法  
	public ResultSet select(String sql,Object [] obj){
		//select * from student where s_age=1 and s_name="号";
		this.getConn();
		
		try {
			ps=conn.prepareStatement(sql);
			System.out.println("发送成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			System.out.println("发送失败");
		}
		
		for(int i=0;i<obj.length;i++){
			try {
				ps.setObject(i+1, obj[i]);
				System.out.println("参数设置成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("参数设置失败");
			}
		}
		try {
			rs=ps.executeQuery();
			System.out.println("查询成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("查询失败");
		}
		
		
		return rs;
	}
	
	
	//修改的方法
	public int update(String sql,Object[]obj){
		this.getConn();
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("发送失败");
		}
		for(int i=0;i<obj.length;i++){
			try {
				ps.setObject(i+1, obj[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("参数设置失败");
			}
		}
		int a=0;
		try {
			a = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("执行sql语句失败");
		}
		return a;
			
	}
	
	
	
	
}
