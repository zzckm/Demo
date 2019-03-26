package com.zhiyou100.servlet.user;

import com.zhiyou100.model.Department;
import com.zhiyou100.model.Role;
import com.zhiyou100.model.User;
import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;
import com.zhiyou100.service.impl.RoleServiceImpl;
import com.zhiyou100.service.impl.UserServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 更新用户
 */
@WebServlet("/user/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//下拉框传值：部门、角色
		List<Department> departments=new ArrayList<Department>();
		DepartmentService ds=new DepartmentServiceImpl();
		try {
			departments=ds.selectDown();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<Role> roles=new ArrayList<Role>();
		RoleService rs=new RoleServiceImpl();
		try {
			roles=rs.selectDown();
		} catch (SQLException e) {
			e.printStackTrace();
		}




		//根据id查询
		int userId = Integer.parseInt(request.getParameter("id"));
		User u = new User();
		UserService us = new UserServiceImpl();
		try {
			//查询指定id的指定行数据
			u = us.findById(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(u);
		request.setAttribute("user", u);
		request.setAttribute("departments",departments);
		request.setAttribute("roles",roles);
		request.getRequestDispatcher("/WEB-INF/view/user/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//获取前端参数
		Integer userId= Integer.valueOf(request.getParameter("userId"));
		String password = request.getParameter("password");
		Integer departmentId = Integer.valueOf(request.getParameter("departmentId"));
		Integer roleId = Integer.valueOf(request.getParameter("roleId"));
		Integer isMale = Integer.valueOf(request.getParameter("isMale"));
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		Integer age = Integer.valueOf(request.getParameter("age"));
		String tel = request.getParameter("tel");
		String idNum = request.getParameter("idNum");
		String email = request.getParameter("email");
		//..................
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp updateTime = Timestamp.valueOf(df.format(new Date()));
		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int createId = (int) session.getAttribute("createrId");

		//实例化传值
		User r = new User();
		r.setUserId(userId);
		r.setPassword(password);
		r.setDepartmentId(departmentId);
		r.setRoleId(roleId);
		r.setIsMale(isMale);
		r.setMobile(mobile);
		r.setAddress(address);
		r.setAge(age);
		r.setTel(tel);
		r.setIdNum(idNum);
		r.setEmail(email);
		r.setUpdateTime(updateTime);
		r.setUpdater(createId);
		UserService uService = new UserServiceImpl();
		System.out.println(r);
		boolean isSave = uService.update(r);
		if(isSave)
		{
			System.out.println("更新成功");
		}
		else
		{
			System.out.println("更新失败");
			doGet(request,response);
		}
		response.sendRedirect(request.getContextPath() + "/user/list");
			//request.getRequestDispatcher("/WEB-INF/view/user/update.jsp").forward(request, response);

	}

}
