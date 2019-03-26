package com.zhiyou100.servlet.customerSource;

import com.zhiyou100.model.CustomerSource;
import com.zhiyou100.service.CustomerSourceService;
import com.zhiyou100.service.impl.CustomerSourceServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.zhiyou100.crm.model.CustomerSource;/

@WebServlet(urlPatterns = { "/customerSource/list" })
public class ListServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;

//	CustomerSourceService customerSourceService = new CustomerSourceServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CustomerSource> list = new ArrayList<CustomerSource>();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		CustomerSourceService customerSourceService = new CustomerSourceServiceImpl();

		try {
			list=customerSourceService.listCcs();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/customerSource/list.jsp").forward(request, response);
	}

}
