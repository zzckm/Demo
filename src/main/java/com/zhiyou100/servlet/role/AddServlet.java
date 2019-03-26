package com.zhiyou100.servlet.role;

import com.zhiyou100.model.Role;
import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.impl.RoleServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = { "/role/add" })
public class AddServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/role/add.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//获取前端参数
		String roleName = request.getParameter("roleName");
		String roleDesc = request.getParameter("roleDesc");
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp createTime = Timestamp.valueOf(df.format(new Date()));

		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int createId = (int) session.getAttribute("createrId");

		//实例化传值
		Role r = new Role();
		r.setRoleName(roleName);
		r.setRoleDesc(roleDesc);
		r.setUpdateTime(createTime);
		r.setUpdater(createId);
		RoleService roleService = new RoleServiceImpl();
		boolean isSave = roleService.save(r);
		if(isSave)
		{
			System.out.println("新增成功");
		}
		else
		{
			System.out.println("新增失败");
			doGet(request,response);
		}

			response.sendRedirect(request.getContextPath() + "/role/list");
		}



}
