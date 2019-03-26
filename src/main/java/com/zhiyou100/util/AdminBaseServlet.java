package com.zhiyou100.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 管理后台请求的共同父类，从此类继承的Servlet能够提供用户信息，如果没有登录就跳到登录页
 * 标记为abstract，只能当做父类使用
 */
public abstract class AdminBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		

		

		
		// 注意一定要调用父类的方法，否则请求相当于没有处理。
		super.service(req, resp);
	}
	

}
