package com.zhiyou100.servlet.message;

import com.zhiyou100.service.MessageService;
import com.zhiyou100.service.impl.MessageServiceImpl;
import com.zhiyou100.util.AdminBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除邮件
 */
@WebServlet("/message/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messageId = Integer.parseInt(request.getParameter("id"));
		String side = request.getParameter("side");
		String forever = request.getParameter("forever");
		boolean isDelete=false;
		System.out.println(side+" side传的值" +messageId +" "+forever);
		if("true".equals(forever)){
			MessageService messageService=new MessageServiceImpl();
			System.out.println("删除垃圾箱的邮件：" +messageId);
			//查询指定id的指定行数据删除
			isDelete=messageService.deleteById(messageId);
		}
		else if(side=="send")
		{
			MessageService messageService=new MessageServiceImpl();
			//查询指定id的指定行数据删除
			isDelete=messageService.updateBystatus(messageId);
		}
		else {
			MessageService messageService=new MessageServiceImpl();
			//查询指定id的指定行数据删除
			isDelete=messageService.updateByRec(messageId);
		}
		if(isDelete){
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}

		response.sendRedirect(request.getContextPath() + "/message/listRemove");
		

		
		// 重定向到请求来源页，注意向学生讲一下Referer请求头
		//response.sendRedirect(request.getHeader("Referer"));
	}

}
