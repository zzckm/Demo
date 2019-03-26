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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 更新角色
 */
@WebServlet("/role/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId = Integer.parseInt(request.getParameter("id"));
		Role role = new Role();
		RoleService roleService = new RoleServiceImpl();
		try {
			//查询指定id的指定行数据
			role = roleService.findById(roleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("role", role);
		request.getRequestDispatcher("/WEB-INF/view/role/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		Integer roleId = Integer.valueOf(request.getParameter("roleId"));
		String roleName = request.getParameter("roleName");
		String roleDesc = request.getParameter("roleDesc");
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp updateTime = Timestamp.valueOf(df.format(new Date()));

		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int updateId = (int) session.getAttribute("createrId");

		//实例化传值
		Role r = new Role();
		r.setRoleId(roleId);
		r.setRoleName(roleName);
		r.setRoleDesc(roleDesc);
		r.setUpdateTime(updateTime);
		r.setUpdater(updateId);

		RoleService rService = new RoleServiceImpl();
		boolean isUpadte = rService.update(r);
		if (isUpadte) {
			System.out.println("角色更新成功");
		}
		else {
			System.out.println("角色更新失败");
			doGet(request,response);
		}

			response.sendRedirect(request.getContextPath() + "/role/list");


			//request.getRequestDispatcher("/WEB-INF/view/role/update.jsp").forward(request, response);

	}

}
