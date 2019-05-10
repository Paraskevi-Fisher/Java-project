package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.People;
import com.service.PeopleService;
import com.service.PeopleServiceImpl;

public class PageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PeopleService ps = new PeopleServiceImpl();
		List<People>result = ps.show();
		req.setAttribute("list", result);
		req.getRequestDispatcher("/PageView.jsp").forward(req, resp);
	}
}
