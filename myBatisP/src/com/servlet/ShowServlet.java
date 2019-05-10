package com.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.StudentService;
import com.Service.StudentServiceImpl;
import com.pojo.PageInfo;
import com.pojo.Student;


public class ShowServlet extends HttpServlet {
	private StudentService studentService = new StudentServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String sname = req.getParameter("sname");
		String tname = req.getParameter("tname");
		int pageSize = 5;
		int pageNumber = 1;
		PageInfo pi = studentService.showPage("¹þ", "1", pageSize, pageNumber);
		String temp = getJson(pi.getList());
		resp.getWriter().write(temp);
		resp.flushBuffer();
		return;
	}
	
	private String getJson(List<Student>list)
	{
		StringBuilder stringBuilder = new StringBuilder("[");
		int len = list.size();
		for (int i = 0;i < len; i++)
		{
			if (i>0) stringBuilder.append(",");
			stringBuilder.append("{");
			
			Student a = list.get(i);
			stringBuilder.append("\"id\":\""+a.getId()+"\",");
			stringBuilder.append("\"Sname\":\""+a.getName()+"\",");
			stringBuilder.append("\"age\":\""+a.getAge()+"\",");
			stringBuilder.append("\"Tname\":\""+a.getTeacher().getName()+"\"");
			stringBuilder.append("}");
		}
		
		stringBuilder.append("]");
		String result = ""+stringBuilder;
		
		
		return result;
	}
}
