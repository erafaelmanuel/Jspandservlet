package com.erm.sample.jee.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erm.sample.jee.exception.LoginException;

@WebServlet(urlPatterns="/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1372461572511L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		final HttpSession session = request.getSession(true);

		if(!session.isNew() && session.getAttribute("user") != null)
			response.sendRedirect("welcome");
		else {
			request.setAttribute("error", false);
	        request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			
			if(username == null || username.trim().equals(""))
				throw new LoginException("username is required");
			if(password == null || password.trim().equals(""))
				throw new LoginException("password is required");
			
			//Basic authentication
			if(!(username.equals("erafaelmanuel") && password.equals("blank00")))
				throw new LoginException("Invalid username or password");
			
			HttpSession session = request.getSession(true);
			
			//Print the session id
			System.out.println("Session ID : " + session.getId());
			
			//Save the user into our session
			session.setAttribute("user", username);
			
			response.sendRedirect("welcome");
			
		}catch(LoginException e) {
			request.setAttribute("error", true);
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}
	
	
}
