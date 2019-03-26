package com.zhiyou100.servlet.customerSource;

import com.zhiyou100.model.CustomerSource;
import com.zhiyou100.service.CustomerSourceService;
import com.zhiyou100.service.impl.CustomerSourceServiceImpl;
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

@WebServlet(urlPatterns = { "/customerSource/add" })
public class AddServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customerSource/add.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("123333333333333333333333333333333333333333333");
		//获取前端参数
		String customerSourceName = request.getParameter("customerSourceName");
		String customerSourceDesc = request.getParameter("customerSourceDesc");
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp createTime = Timestamp.valueOf(df.format(new Date()));

		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int createrId = (int) session.getAttribute("createrId");

		//实例化传值
		CustomerSource r = new CustomerSource();
		r.setCustomerSourceName(customerSourceName);
		r.setCustomerSourceDesc(customerSourceDesc);
		r.setCreateTime(createTime);
		r.setCreater(createrId);
		CustomerSourceService ccs = new CustomerSourceServiceImpl();
		System.out.println(r);
		boolean isSave = false;
			isSave = ccs.save(r);

		if(isSave)
		{
			System.out.println("新增成功");
		}
		else
		{
			System.out.println("新增失败");
			doGet(request,response);
		}
//		System.out.println(customerSource);
//
//		if (customerSourceService.add(customerSource)) {
			response.sendRedirect(request.getContextPath() + "/customerSource/list");
//		}
//		else{
		//	doGet(request, response);
//		}
		
	}

}
