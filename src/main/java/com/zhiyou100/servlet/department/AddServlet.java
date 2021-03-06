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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "DepartmentAddServlet", urlPatterns = { "/department/add" })
public class AddServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/department/add.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//设置编码格式
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
			//获取前端参数
			String departmentName = request.getParameter("departmentName");
			String departmentDesc = request.getParameter("departmentDesc");
			//设置发送时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Timestamp createTime = Timestamp.valueOf(df.format(new Date()));

			//获取session中的登录用户  id  发送人
			HttpSession session = request.getSession();
			int createId = (int) session.getAttribute("createrId");

			//实例化传值
			Department d = new Department();
			d.setDepartmentName(departmentName);
			d.setDepartmentDesc(departmentDesc);
			d.setUpdateTime(createTime);
			d.setUpdater(createId);
		DepartmentService dService = new DepartmentServiceImpl();
		boolean isSave = dService.save(d);
		if(isSave)
		{
			System.out.println("新增成功");
		}
		else
		{
			System.out.println("新增失败");
			doGet(request,response);
		}
		response.sendRedirect(request.getContextPath() + "/department/list");

		//doGet(request, response);

		
	}

}
