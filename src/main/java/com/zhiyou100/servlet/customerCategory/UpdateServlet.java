package com.zhiyou100.servlet.customerCategory;

import com.zhiyou100.model.CustomerCategory;
import com.zhiyou100.service.CustomerCategoryService;
import com.zhiyou100.service.impl.CustomerCategoryServiceImpl;
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

//import com.zhiyou100.crm.model.CustomerCategory;
//import com.zhiyou100.crm.service.CustomerCategoryService;
//import com.zhiyou100.crm.service.impl.CustomerCategoryServiceImpl;

/**
 * 更新分类
 */
@WebServlet("/customerCategory/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
//
//	CustomerCategoryService customerCategoryService = new CustomerCategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		int customerCategoryId = Integer.parseInt(request.getParameter("id"));
		CustomerCategoryService customerCategoryService=new CustomerCategoryServiceImpl();
		CustomerCategory customerCategory = null;
		try {
			customerCategory = customerCategoryService.getById(customerCategoryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("customerCategory", customerCategory);
		request.getRequestDispatcher("/WEB-INF/view/customerCategory/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		Integer customerCategoryId=Integer.parseInt(request.getParameter("customerCategoryId"));
		String customerCategoryName=request.getParameter("customerCategoryName");
		String  customerCategoryDesc=request.getParameter("customerCategoryDesc");
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp updateTime = Timestamp.valueOf(df.format(new Date()));

		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int updateId = (int) session.getAttribute("createrId");

		//实例化传值
		CustomerCategory cc = new CustomerCategory();

		cc.setCustomerCategoryId(customerCategoryId);
		cc.setCustomerCategoryName(customerCategoryName);
		cc.setCustomerCategoryDesc(customerCategoryDesc);
		cc.setUpdateTime(updateTime);
		cc.setUpdater(updateId);
		System.out.println(cc);
		CustomerCategoryService ccs=new CustomerCategoryServiceImpl();

		boolean isUpadte = ccs.update(cc);
		if (isUpadte) {
			System.out.println("客户分类更新成功");
		}
		else {
			System.out.println("客户分类更新失败");
			doGet(request,response);
		}
		response.sendRedirect(request.getContextPath() + "/customerCategory/list");


	}

}
