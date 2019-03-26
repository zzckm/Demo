package com.zhiyou100.servlet.customerCategory;

import com.zhiyou100.model.CustomerCategory;
import com.zhiyou100.service.CustomerCategoryService;
import com.zhiyou100.service.impl.CustomerCategoryServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/customerCategory/list")
public class ListServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;

//	CustomerCategoryService customerCategoryService = new CustomerCategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CustomerCategory> list = new ArrayList<CustomerCategory>();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		CustomerCategoryService customerCategoryService = new CustomerCategoryServiceImpl();

		try {
			list=customerCategoryService.listCcs();

		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/customerCategory/list.jsp").forward(request, response);
	}

}
