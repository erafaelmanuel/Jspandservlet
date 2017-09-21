package com.erm.sample.jee.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@WebServlet(name="thymeleaf", urlPatterns="*.html")
public class ThymeleafServletDispatcher extends HttpServlet {
	
	private static final long serialVersionUID = 15465465463423324L;
	
	private ServletContextTemplateResolver templateResolver;
	
	@Override
	public void init() throws ServletException {
		templateResolver = new ServletContextTemplateResolver();
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setCacheTTLMs(3600000L);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		WebContext ctx = new WebContext(request, response, getServletConfig().getServletContext(), 
				request.getLocale());
		TemplateEngine templateEngine = new TemplateEngine();
		
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.process(getTemplateName(request), ctx, response.getWriter());  
	}
	
	protected String getTemplateName(HttpServletRequest request) {
		String requestPath = request.getRequestURI();
        String contextPath = request.getContextPath() != null ? request.getContextPath() : "";
        String template = requestPath.substring(contextPath.length());
		
        return template;
	}
}
