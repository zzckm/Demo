package com.zhiyou100.servlet.department;

import com.zhiyou100.model.Department;
import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;
import com.zhiyou100.util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = { "/department/listview" })
public class ListViewServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
       

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		DepartmentService noticeService = new DepartmentServiceImpl();
		List<Department> departments=new ArrayList<Department>();

		try {
			departments=noticeService.listDePart();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//分页
		int total=departments.size();
		int pageSize=5;
		int pageNo = 1;

		String pn = request.getParameter("pageNo");
		if (pn != null && !"".equals(pn)) {
			pageNo = Integer.parseInt(pn);
		}
		Pager pager=new Pager(total,pageNo,pageSize);

		List<Department> list = new ArrayList<Department>();
		for(int i = (pageNo - 1)* pageSize ; i < pageNo * pageSize ; i++){
			if(i == departments.size()){
				break;
			}
			list.add(departments.get(i));
		}
		request.setAttribute("pager", pager);
		request.setAttribute("list", list);
		

		
		request.getRequestDispatcher("/WEB-INF/view/department/listview.jsp").forward(request, response);
	}

}
