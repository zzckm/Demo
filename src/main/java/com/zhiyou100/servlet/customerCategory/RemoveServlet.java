package com.zhiyou100.servlet.customerCategory;

import com.zhiyou100.service.CustomerCategoryService;
import com.zhiyou100.service.impl.CustomerCategoryServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除分类
 */
@WebServlet("/customerCategory/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
//	CustomerCategoryService customerCategoryService = new CustomerCategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sourceId = Integer.parseInt(request.getParameter("id"));

		CustomerCategoryService us=new CustomerCategoryServiceImpl();
		//查询指定id的指定行数据删除
		boolean isDelete=us.deleteById(sourceId);
		if(true){
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}
		response.sendRedirect(request.getContextPath() + "/customerCategory/list");
	}

}
