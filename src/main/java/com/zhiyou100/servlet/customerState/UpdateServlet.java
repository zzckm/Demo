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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 更新客户状态
 */
@WebServlet("/customerState/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerStateId = Integer.parseInt(request.getParameter("id"));
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		//int customerSourceId = Integer.parseInt(request.getParameter("id"));
		System.out.println(customerStateId+"   123213131");
		//Integer SourceId = Integer.parseInt(request.getParameter("id"));
		CustomerStateService css=new CustomerStateServiceImpl();
		CustomerState cs =new CustomerState();
		try {
			cs = css.getById(customerStateId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("customerState", cs);
		request.getRequestDispatcher("/WEB-INF/view/customerState/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		Integer customerStateId=Integer.parseInt(request.getParameter("customerStateId"));
		String customerStateName=request.getParameter("customerStateName");
		String  customerStateDesc=request.getParameter("customerStateDesc");
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp updateTime = Timestamp.valueOf(df.format(new Date()));

		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int updateId = (int) session.getAttribute("createrId");

		//实例化传值
		CustomerState cc = new CustomerState();

		cc.setCustomerStateId(customerStateId);
		cc.setCustomerStateName(customerStateName);
		cc.setCustomerStateDesc(customerStateDesc);
		cc.setUpdateTime(updateTime);
		cc.setUpdater(updateId);
		System.out.println(cc);
		CustomerStateService ccs=new CustomerStateServiceImpl();

		boolean isUpadte = ccs.update(cc);
		if (isUpadte) {
			System.out.println("客户来源更新成功");
		}
		else {
			System.out.println("客户来源更新失败");
			doGet(request,response);
		}
			//request.getRequestDispatcher("/WEB-INF/view/customerState/update.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/customerState/list");
	}

}
