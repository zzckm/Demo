package com.zhiyou100.servlet.user;

import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.UserServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除用户
 */
@WebServlet("/user/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userId = Integer.parseInt(request.getParameter("id"));
		UserService us=new UserServiceImpl();
		//查询指定id的指定行数据删除
		boolean isDelete=us.deleteById(userId);
		if(true){
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}


		response.sendRedirect(request.getContextPath() + "/user/list");
	}

}
