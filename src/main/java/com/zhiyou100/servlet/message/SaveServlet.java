package com.zhiyou100.servlet.message;

import com.zhiyou100.model.Message;
import com.zhiyou100.model.User;
import com.zhiyou100.service.MessageService;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.MessageServiceImpl;
import com.zhiyou100.service.impl.UserServiceImpl;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = { "/message/save" })
public class SaveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
//	MessageService messageService = new MessageServiceImpl();
//	UserService userService = new UserServiceImpl();
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//下拉框传值：部门、角色
		List<User> users=new ArrayList<User>();
		UserService ds=new UserServiceImpl();
		try {
			users=ds.selectDown();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("users",users);
		request.getRequestDispatcher("/WEB-INF/view/message/save.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//获取前端参数
		Integer receiverId = Integer.valueOf(request.getParameter("receiver"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String senderStatus=request.getParameter("send");
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp createTime = Timestamp.valueOf(df.format(new Date()));
		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int createId = (int) session.getAttribute("createrId");
		// 注意这里判断用户点哪个按扭的方法！
		boolean send = request.getParameter("send") != null;
		Message m = new Message();


			m.setSubject(subject);
			m.setContent(content);
			m.setSender(createId);

			//m.setSaveTime(createTime);

			m.setSendDelete(2);
		if(send) {
			m.setSendTime(createTime);
			m.setSendStatus(2);
		}
		else {
			m.setSaveTime(createTime);
			m.setSendStatus(0);
		}
			m.setReceiver(receiverId);

			m.setReceiveDelete(2);
			m.setReceiveStatus(0);

		MessageService messageService=new MessageServiceImpl();
		boolean isSend=messageService.save(m,send);

		response.sendRedirect(request.getContextPath() + "/message/listSend");
		System.out.println(send);
		

		
	}

}
