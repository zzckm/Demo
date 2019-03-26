package com.zhiyou100.servlet.user;

import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.UserServiceImpl;
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
 * 用户列表
 */
@WebServlet("/user/listview")
public class ListViewServlet extends AdminBaseServlet {
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
		UserService userService = new UserServiceImpl();
		List<User> users=new ArrayList<User>();
		try {
			users=userService.searchByKeyWord(searchField,keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//分页
		int total=users.size();
		int pageSize=5;
		int pageNo = 1;

		String pn = request.getParameter("pageNo");
		if (pn != null && !"".equals(pn)) {
			pageNo = Integer.parseInt(pn);
		}
		Pager pager=new Pager(total,pageNo,pageSize);

		List<User> list = new ArrayList<User>();
		for(int i = (pageNo - 1)* pageSize ; i < pageNo * pageSize ; i++){
			if(i == users.size()){
				break;
			}
			list.add(users.get(i));
		}

		request.setAttribute("list", users);

		request.setAttribute("searchField", searchField);
		request.setAttribute("keyword", keyword);
		request.setAttribute("pager", pager);
		System.out.println("listview-------------------get");
		

		request.getRequestDispatcher("/WEB-INF/view/user/listview.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		String field = request.getParameter("searchField");
		String keyword = request.getParameter("keyword");
		System.out.println(field+" "+keyword);
		UserService rService = new UserServiceImpl();
		List<User> users=new ArrayList<User>();
		try {
			users=rService.searchByKeyWord(field,keyword);
			for(User u :users){
				System.out.println("-=-"+u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*int pageNo = 1;
		String pn = request.getParameter("pageNo");
		if (pn != null && !"".equals(pn)) {
			pageNo = Integer.parseInt(pn);
		}*/
		request.setAttribute("list", users);
		request.setAttribute("field", field);
		request.setAttribute("keyword", keyword);
		//request.setAttribute("pageNo", pageNo);
		System.out.println("listview-------------------post");
		request.getRequestDispatcher("/WEB-INF/view/user/listview.jsp").forward(request, response);
		//doGet(request, response);
	}

}
