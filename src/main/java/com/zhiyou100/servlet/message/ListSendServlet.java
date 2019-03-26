package com.zhiyou100.servlet.message;

import com.zhiyou100.model.Message;
import com.zhiyou100.service.MessageService;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.MessageServiceImpl;
import com.zhiyou100.service.impl.NoticeServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;
import com.zhiyou100.util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/message/listSend")
public class ListSendServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
       

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String keyword = "";
		String searchField = "";
		//int pageNo = 1;

		if ("POST".equalsIgnoreCase(request.getMethod())) {
			searchField = (String)request.getAttribute("searchField");
			keyword = (String)request.getAttribute("keyword");

			//pageNo = (int)request.getAttribute("pageNo");
		}
		MessageService messageService = new MessageServiceImpl();
		List<Message> messages=new ArrayList<Message>();
		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int createId = (int) session.getAttribute("createrId");
		try {
			messages=messageService.searchByKeyWord(searchField,keyword,createId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Message m:messages
		) {
			System.out.println(m);

		}
		//分页
		int total=messages.size();
		int pageSize=5;
		int pageNo = 1;

		String pn = request.getParameter("pageNo");
		if (pn != null && !"".equals(pn)) {
			pageNo = Integer.parseInt(pn);
		}
		Pager pager=new Pager(total,pageNo,pageSize);

		List<Message> list = new ArrayList<Message>();
		for(int i = (pageNo - 1)* pageSize ; i < pageNo * pageSize ; i++){
			if(i == messages.size()){
				break;
			}
			list.add(messages.get(i));
		}
		request.setAttribute("pager", pager);
		request.setAttribute("list", list);


		request.setAttribute("searchField", searchField);
		request.setAttribute("keyword", keyword);
		//request.setAttribute("pageNo", pageNo);
		System.out.println("list-------------------get");

		request.getRequestDispatcher("/WEB-INF/view/message/listSend.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String searchField = request.getParameter("searchField");
		String keyword = request.getParameter("keyword");
		NoticeService noticeService = new NoticeServiceImpl();
		MessageService messageService = new MessageServiceImpl();
		List<Message> messages=new ArrayList<Message>();
		//获取session中的登录用户  id  发送人
		HttpSession session = request.getSession();
		int createId = (int) session.getAttribute("createrId");
		try {
			messages=messageService.searchByKeyWord(searchField,keyword,createId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//分页
		int total=messages.size();
		int pageSize=5;
		int pageNo = 1;

		String pn = request.getParameter("pageNo");
		if (pn != null && !"".equals(pn)) {
			pageNo = Integer.parseInt(pn);
		}
		Pager pager=new Pager(total,pageNo,pageSize);

		List<Message> list = new ArrayList<Message>();
		for(int i = (pageNo - 1)* pageSize ; i < pageNo * pageSize ; i++){
			if(i == messages.size()){
				break;
			}
			list.add(messages.get(i));
		}
		request.setAttribute("pager", pager);
		request.setAttribute("list", list);
		request.setAttribute("searchField", searchField);
		request.setAttribute("keyword", keyword);
		//request.setAttribute("pageNo", pageNo);
		System.out.println("list-------------------post");
		//request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/view/message/listSend.jsp").forward(request, response);


/*		int pageNo = 1;
		String pn = request.getParameter("pageNo");
		if (pn != null && !"".equals(pn)) {
			pageNo = Integer.parseInt(pn);
		}
		
		request.setAttribute("field", field);
		request.setAttribute("keyword", keyword);
		request.setAttribute("pageNo", pageNo);*/
		
		//doGet(request, response);
	}

}
