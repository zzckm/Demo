package com.zhiyou100.servlet.department;

import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除部门
 */
@WebServlet("/department/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int departmentId = Integer.parseInt(request.getParameter("id"));
		//Department department=new Department();
		DepartmentService departmentService=new DepartmentServiceImpl();
		//查询指定id的指定行数据删除
		boolean isDelete=departmentService.deleteById(departmentId);
		if(true){
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}
		response.sendRedirect(request.getContextPath() + "/department/list");
	}

}
