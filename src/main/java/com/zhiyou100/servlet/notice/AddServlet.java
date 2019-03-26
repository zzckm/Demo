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
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 发布公告
 */
@WebServlet("/notice/add")
public class AddServlet extends AdminBaseServlet {

	private static final long serialVersionUID = 1L;
	

       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/notice/add.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		System.out.println("1231232");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String pubTime1= request.getParameter("pubTime");
		String expireTime1= request.getParameter("expireTime");
		//时间格式转换
		System.out.println(pubTime1+" "+expireTime1);
		String pub=pubTime1+" 00:00:00";
		String exp=expireTime1+" 00:00:00";
		Timestamp pubTime=null;
		Timestamp expireTime=null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			pubTime = new Timestamp(format.parse(pub).getTime());
			expireTime=new Timestamp(format.parse(exp).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String subject=request.getParameter("subject");
		int receiveId= Integer.parseInt(request.getParameter("receiveId"));
		String text=request.getParameter("text");
		//实例化对象
		Notice notice=new Notice();
		//设置发送时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Timestamp strDate= Timestamp.valueOf(df.format(new Date()));
		notice.setCreate_time(strDate);
		//获取session中的登录用户  id  发送人
		HttpSession session=request.getSession();
		int createrId= (int) session.getAttribute("createrId");
		//给notice传参数

		notice.setCreater(createrId);
		notice.setPub_time(pubTime);
		notice.setExpire_time(expireTime);
		notice.setSubject(subject);
		notice.setReceive_id(receiveId);
		notice.setStatus(2);
		notice.setText(text);
		NoticeService noticeService=new NoticeServiceImpl();
		boolean isAdd=noticeService.add(notice);
		if(isAdd){
			System.out.println("新增公告成功");
		}
		else{
			System.out.println("新增公告失败");
			doGet(request,response);
		}

		response.sendRedirect(request.getContextPath() + "/notice/list");

		
	}

}
