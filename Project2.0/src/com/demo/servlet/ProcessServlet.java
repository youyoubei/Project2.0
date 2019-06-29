package com.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ProcessServlet extends HttpServlet {


	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String inputCode = request.getParameter("inputCode");
		
		HttpSession session = request.getSession(); //获取HttpSession 中的随机验证码
		String validateCode = (String)(session.getAttribute("validateCode"));
		
		if(validateCode.equalsIgnoreCase(inputCode) && "admin".equals(name) && "admin".equals(pwd)) {
			
			
			session.removeAttribute("validateCode");
			session.setAttribute("admin", name);
			//response.setHeader("refresh", "1,url=page.jsp");
			request.getRequestDispatcher("/page.jsp").forward(request, response);
		} 
if(validateCode.equalsIgnoreCase(inputCode) && "ZHANG".equals(name) && "ZHANG".equals(pwd)) {
			
			
			session.removeAttribute("validateCode");
			session.setAttribute("ZHANG", name);
			//response.setHeader("refresh", "1,url=page.jsp");
			request.getRequestDispatcher("/page.jsp").forward(request, response);
		}
		else {
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		
	}

}
