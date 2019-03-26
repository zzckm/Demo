package com.zhiyou100.servlet.user;

import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;
	


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

			// 登录成功，用重定向的方法跳到后台首页
			// 注意，因为重定向是浏览器行为，所以地址要加上应用路径，注意观察浏览器地址栏中地址的变化
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService us = new UserServiceImpl();
		User existUser=new User();
		try {
			existUser = us.login(user);
			System.out.println(existUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		//List<User> users = new ArrayList<User>();
		if (session.getAttribute("username") == null) {
			if (existUser.getUsername()!=null) {
				session.setAttribute("createrId",existUser.getUserId());
				session.setAttribute("username", username);
				response.sendRedirect(request.getContextPath() + "/admin.jsp");
				System.out.println("createrID：   "+session.getAttribute("createrId"));
				//request.setAttribute("users",users);
				// request.getRequestDispatcher("success.jsp").forward(request,response );
				System.out.println("登录成功");
			} else {
				request.setAttribute("errorMessage", "用户名或密码错误！");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				System.out.println("登录失败");
			}
		}



			


		

	}

}
