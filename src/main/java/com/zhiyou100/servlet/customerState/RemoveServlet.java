package com.zhiyou100.servlet.customerState;

import com.zhiyou100.service.CustomerStateService;
import com.zhiyou100.service.impl.CustomerStateServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除客户状态
 */
@WebServlet("/customerState/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerStateId = Integer.parseInt(request.getParameter("id"));
		CustomerStateService us=new CustomerStateServiceImpl();
		//查询指定id的指定行数据删除
		boolean isDelete=us.deleteById(customerStateId);
		if(true){
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}

		response.sendRedirect(request.getContextPath() + "/customerState/list");
	}

}
