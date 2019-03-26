package com.zhiyou100.servlet.customerState;

import com.zhiyou100.model.CustomerState;
import com.zhiyou100.service.CustomerStateService;
import com.zhiyou100.service.impl.CustomerStateServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/customerState/list")
public class ListServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CustomerState> list = new ArrayList<CustomerState>();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		CustomerStateService customerStateService = new CustomerStateServiceImpl();

		try {
			list=customerStateService.listCcs();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/customerState/list.jsp").forward(request, response);
	}

}
