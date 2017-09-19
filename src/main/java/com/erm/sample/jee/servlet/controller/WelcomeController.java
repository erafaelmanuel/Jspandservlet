package com.erm.sample.jee.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/welcome")
public class WelcomeController extends HttpServlet {

	private static final long serialVersionUID = 134543524235623L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		final HttpSession session = request.getSession(true);
		
		if(session.isNew() || session.getAttribute("user") == null)
			response.sendRedirect("login");
		else
			request.getRequestDispatcher("WEB-INF/templates/welcome.jsp").forward(request, response);
	}
}
