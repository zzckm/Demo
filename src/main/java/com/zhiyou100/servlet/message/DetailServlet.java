package com.zhiyou100.servlet.message;

import com.zhiyou100.model.Message;
import com.zhiyou100.service.MessageService;
import com.zhiyou100.service.impl.MessageServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 邮件详情
 */
@WebServlet("/message/detail")
public class DetailServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messageId = Integer.parseInt(request.getParameter("id"));
		System.out.println("_________________________________"+messageId);
		Message message=new Message();
		MessageService messageService=new MessageServiceImpl();
		/*//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		String senderName = (String) session.getAttribute("username");*/
		try {
			//查询指定id的指定行数据
			message=messageService.findById(messageId);
			String receiverName=messageService.findByIdSendName(messageId);
			String senderName=messageService.findByIdReceName(messageId);
			message.setSenderName(senderName);
			message.setReceiverName(receiverName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(message);
		request.setAttribute("message",message);
		request.getRequestDispatcher("/WEB-INF/view/message/detail.jsp").forward(request, response);
	}

}
