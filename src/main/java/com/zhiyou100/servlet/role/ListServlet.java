package com.zhiyou100.servlet.role;

import com.zhiyou100.model.Role;
import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.impl.RoleServiceImpl;
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

@WebServlet(name = "RoleListServlet", urlPatterns = { "/role/list" })
public class ListServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		RoleService roleService = new RoleServiceImpl();
		List<Role> roles=new ArrayList<Role>();

		try {
			roles=roleService.listRole();
			for(Role r:roles)
			{
				System.out.println(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//分页
		int total=roles.size();
		int pageSize=5;
		int pageNo = 1;

		String pn = request.getParameter("pageNo");
		if (pn != null && !"".equals(pn)) {
			pageNo = Integer.parseInt(pn);
		}
		Pager pager=new Pager(total,pageNo,pageSize);

		List<Role> list = new ArrayList<Role>();
		for(int i = (pageNo - 1)* pageSize ; i < pageNo * pageSize ; i++){
			if(i == roles.size()){
				break;
			}
			list.add(roles.get(i));
		}
		request.setAttribute("pager", pager);
		request.setAttribute("list", list);

		request.getRequestDispatcher("/WEB-INF/view/role/list.jsp").forward(request, response);
	}

}
