package com.zhiyou100.servlet.notice;

import com.zhiyou100.model.Notice;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.NoticeServiceImpl;
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
 * 更新通知公告
 */
@WebServlet("/notice/update")
public class UpdateServlet extends AdminBaseServlet {
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
		request.getRequestDispatcher("/WEB-INF/view/notice/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------------=================---------------------------");
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		Timestamp pubTime= Timestamp.valueOf(request.getParameter("pub_time"));
		Timestamp expireTime= Timestamp.valueOf(request.getParameter("expire_time"));
		String subject=request.getParameter("subject");
		String receiveIdStr=request.getParameter("receive_id");
		String text=request.getParameter("text");
		String noticeIdStr= request.getParameter("noticeId");
		Integer receiveId= Integer.parseInt(receiveIdStr.trim());
		Integer noticeId= Integer.parseInt(noticeIdStr.trim());
		//实例化对象
		Notice notice=new Notice();
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp strDate= Timestamp.valueOf(df.format(new Date()));

		//获取session中的登录用户  id  发送人
		HttpSession session=request.getSession();
		int updateId= (int) session.getAttribute("createrId");
		//给notice传参数
		notice.setUpdater(updateId);
		notice.setUpdate_time(strDate);
		notice.setPub_time(pubTime);
		notice.setExpire_time(expireTime);
		notice.setSubject(subject);
		notice.setReceive_id(receiveId);
		notice.setText(text);
		notice.setNotice_id(noticeId);
		NoticeService noticeService=new NoticeServiceImpl();
		//数据更新

		boolean isAdd=noticeService.update(notice);
		if(isAdd)
		{
			System.out.println("更新成功");
		}
		else
		{
			System.out.println("更新失败");
			doGet(request,response);
		}
		response.sendRedirect(request.getContextPath() + "/notice/list");

	}

}
