package com.zhiyou100.servlet.message;

import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更新邮件
 */
@WebServlet("/message/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messageId = Integer.parseInt(request.getParameter("id"));

		request.getRequestDispatcher("/WEB-INF/view/message/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		// 注意这里判断用户点哪个按扭的方法！
		boolean send = request.getParameter("send") != null;
		

			response.sendRedirect(request.getContextPath() + "/message/listSave");
		}

		


}
