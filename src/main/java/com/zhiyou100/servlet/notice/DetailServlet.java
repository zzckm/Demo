package com.zhiyou100.servlet.notice;

import com.zhiyou100.model.Notice;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.NoticeServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 公告详情
 */
@WebServlet("/notice/detail")
public class DetailServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeId = Integer.parseInt(request.getParameter("id"));
		Notice notice=new Notice();
		NoticeService noticeService=new NoticeServiceImpl();
		try {
			//查询指定id的指定行数据
			notice=noticeService.findById(noticeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("notice",notice);
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);

	}

}
