package com.zhiyou100.servlet.notice;

import com.zhiyou100.model.Notice;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.NoticeServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;
import com.zhiyou100.util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 公告列表----内部公告
 */
@WebServlet("/notice/listview")
public class ListViewServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
//	NoticeService noticeService = new NoticeServiceImpl();
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String field = "";
		String keyword = "";
		//int pageNo = 1;

		if ("POST".equalsIgnoreCase(request.getMethod())) {
			field = (String) request.getAttribute("field");
			keyword = (String) request.getAttribute("keyword");
			//pageNo = (int) request.getAttribute("pageNo");
		}
		NoticeService noticeService = new NoticeServiceImpl();
		List<Notice> notices=new ArrayList<Notice>();
		try {
			notices=noticeService.searchByKeyWord(field,keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//分页
		int total=notices.size();
		int pageSize=5;
		int pageNo = 1;

		String pn = request.getParameter("pageNo");
		if (pn != null && !"".equals(pn)) {
			pageNo = Integer.parseInt(pn);
		}
		Pager pager=new Pager(total,pageNo,pageSize);

		List<Notice> list = new ArrayList<Notice>();
		for(int i = (pageNo - 1)* pageSize ; i < pageNo * pageSize ; i++){
			if(i == notices.size()){
				break;
			}
			list.add(notices.get(i));
		}

		request.setAttribute("pager", pager);
		request.setAttribute("notices", list);
		request.setAttribute("field", field);
		request.setAttribute("keyword", keyword);
		//request.setAttribute("pageNo", pageNo);
		System.out.println("listview-------------------get");
		request.getRequestDispatcher("/WEB-INF/view/notice/listview.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String field = request.getParameter("searchField");
		String keyword = request.getParameter("keyword");
		NoticeService noticeService = new NoticeServiceImpl();
		List<Notice> notices=new ArrayList<Notice>();
		try {
			notices=noticeService.searchByKeyWord(field,keyword);
			for(Notice u :notices){
				System.out.println("-=-"+u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

/*		int pageNo = 1;
		String pn = request.getParameter("pageNo");
		if (pn != null && !"".equals(pn)) {
			pageNo = Integer.parseInt(pn);
		}*/
		request.setAttribute("notices", notices);
		request.setAttribute("field", field);

			request.setAttribute("keyword", keyword);

		//request.setAttribute("pageNo", pageNo);
		System.out.println("listview-----------------post");


		doGet(request, response);
	}

}
