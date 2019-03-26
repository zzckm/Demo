package com.zhiyou100.servlet.customerState;

import com.zhiyou100.model.CustomerState;
import com.zhiyou100.service.CustomerStateService;
import com.zhiyou100.service.impl.CustomerStateServiceImpl;
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

@WebServlet("/customerState/add")
public class AddServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	//CustomerStateService customerStateService = new CustomerStateServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customerState/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CustomerState customerState = new CustomerState();
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		//获取前端参数
		String customerStateName = request.getParameter("customerStateName");
		String customerStateDesc = request.getParameter("customerStateDesc");
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp updateTime = Timestamp.valueOf(df.format(new Date()));

		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int updateId = (int) session.getAttribute("createrId");

		//实例化传值
		CustomerState r = new CustomerState();
		r.setCustomerStateName(customerStateName);
		r.setCustomerStateDesc(customerStateDesc);
		r.setCreateTime(updateTime);
		r.setCreater(updateId);
		CustomerStateService ccs = new CustomerStateServiceImpl();
		boolean isSave = ccs.save(r);
		if(isSave)
		{
			System.out.println("新增成功");
		}
		else
		{
			System.out.println("新增失败");
			doGet(request,response);
		}
		response.sendRedirect(request.getContextPath() + "/customerState/list");
	}

}
