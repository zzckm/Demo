package com.zhiyou100.servlet.department;

import com.zhiyou100.model.Department;
import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;
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
 * 更新部门
 */
@WebServlet("/department/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int departmentId = Integer.parseInt(request.getParameter("id"));
		Department department = new Department();
		DepartmentService noticeService = new DepartmentServiceImpl();
		try {
			//查询指定id的指定行数据
			department = noticeService.findById(departmentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("department", department);
		request.getRequestDispatcher("/WEB-INF/view/department/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		Integer departmentId = Integer.valueOf(request.getParameter("departmentId"));
		String departmentName = request.getParameter("departmentName");
		String departmentDesc = request.getParameter("departmentDesc");
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp updateTime = Timestamp.valueOf(df.format(new Date()));

		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int updateId = (int) session.getAttribute("createrId");

		//实例化传值
		Department d = new Department();
		d.setDepartmentId(departmentId);
		d.setDepartmentName(departmentName);
		d.setDepartmentDesc(departmentDesc);
		d.setUpdateTime(updateTime);
		d.setUpdater(updateId);
		System.out.println(d);
		DepartmentService dService = new DepartmentServiceImpl();
		boolean isUpadte = dService.update(d);
		if (isUpadte) {
			System.out.println("部门更新成功");
		}
		else {
			System.out.println("部门更新失败");
			doGet(request,response);
		}
response.sendRedirect(request.getContextPath()+"/department/list");

}

			//request.getRequestDispatcher("/WEB-INF/view/department/update.jsp").forward(request, response);



}
