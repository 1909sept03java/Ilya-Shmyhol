package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.EmployeeCredentials;
import com.revature.beans.EmployeeInfo;
import com.revature.service.AuthenticationService;

//@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	private AuthenticationService authService = new AuthenticationService();
	private static final long serialVersionUID = 817105812389880890L;

	/*
	 * Create two methods: - a doGet to handle GET requests for our login page - a
	 * doPost to handle POST requests with credentials
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// serve the login.html page as a response
		// RequestDispatcher is used to perform a 'forward' 
		// (pass the request to another resource without the client knowing)
		//resp.getWriter().write("hello world");
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		EmployeeCredentials creds = new EmployeeCredentials();
		creds.setUsername(req.getParameter("username"));
		creds.setPassword(req.getParameter("password"));
		EmployeeInfo u = authService.authenticateUser(creds);
		resp.getWriter().write(creds.getPassword());
		
		if (u != null) {


			session.setAttribute("userId", u.getId());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("password", creds.getPassword());
			session.setAttribute("username", creds.getUsername());

			session.setAttribute("problem", null);
			resp.sendRedirect("profile");
		} else {
			session.setAttribute("problem", "invalid credentials");

			resp.sendRedirect("login");
		}
	}
}