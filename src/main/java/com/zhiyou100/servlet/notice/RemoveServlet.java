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

/**
 * 删除通知
 */
@WebServlet("/notice/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
//	NoticeService noticeService = new NoticeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeId = Integer.parseInt(request.getParameter("id"));
		Notice notice=new Notice();
		NoticeService noticeService=new NoticeServiceImpl();
		//查询指定id的指定行数据删除
		boolean isDelete=noticeService.deleteById(noticeId);
		if(isDelete){
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}

		//request.setAttribute("notice",notice);
//		noticeService.removeById(noticeId, user.getUserId(), Timestamp.valueOf(LocalDateTime.now()));
		response.sendRedirect(request.getContextPath() + "/notice/list");
	}

}
