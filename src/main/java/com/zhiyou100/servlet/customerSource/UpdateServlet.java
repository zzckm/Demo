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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 更新角色
 */
@WebServlet("/customerSource/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("1233112321");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		int customerSourceId = Integer.parseInt(request.getParameter("id"));
		System.out.println(customerSourceId+"   123213131");
		//Integer SourceId = Integer.parseInt(request.getParameter("id"));
		CustomerSourceService css=new CustomerSourceServiceImpl();
		CustomerSource cs =new CustomerSource();
		try {
			cs = css.getById(customerSourceId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("customerSource", cs);
		request.getRequestDispatcher("/WEB-INF/view/customerSource/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		Integer customerSourceId=Integer.parseInt(request.getParameter("customerSourceId"));
		String customerSourceName=request.getParameter("customerSourceName");
		String  customerSourceDesc=request.getParameter("customerSourceDesc");
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp updateTime = Timestamp.valueOf(df.format(new Date()));

		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int updateId = (int) session.getAttribute("createrId");

		//实例化传值
		CustomerSource cc = new CustomerSource();

		cc.setCustomerSourceId(customerSourceId);
		cc.setCustomerSourceName(customerSourceName);
		cc.setCustomerSourceDesc(customerSourceDesc);
		cc.setUpdateTime(updateTime);
		cc.setUpdater(updateId);
		System.out.println(cc);
		CustomerSourceService ccs=new CustomerSourceServiceImpl();

		boolean isUpadte = ccs.update(cc);
		if (isUpadte) {
			System.out.println("客户来源更新成功");
		}
		else {
			System.out.println("客户来源更新失败");
			doGet(request,response);
		}
		response.sendRedirect(request.getContextPath() + "/customerSource/list");

	}

}
