package com.zhiyou100.servlet.role;

import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.impl.RoleServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除角色
 */
@WebServlet("/role/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId = Integer.parseInt(request.getParameter("id"));
		RoleService roleService=new RoleServiceImpl();
		//查询指定id的指定行数据删除
		boolean isDelete=roleService.deleteById(roleId);
		if(true){
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}

		response.sendRedirect(request.getContextPath() + "/role/list");
	}

}
