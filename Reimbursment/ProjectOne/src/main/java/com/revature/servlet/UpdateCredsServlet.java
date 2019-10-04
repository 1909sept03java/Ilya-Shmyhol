package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ChangeInfoDAOImpl;

@WebServlet("/changeInfo")
public class UpdateCredsServlet extends HttpServlet {

	private static final long serialVersionUID = 6639140136572357884L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		ChangeInfoDAOImpl change = new ChangeInfoDAOImpl();
			if(null!=req.getParameter("changeFirstnameCheck")) {
				change.changeFirstName(req.getParameter("changeFirstname"), Integer.parseInt(session.getAttribute("userId").toString()));
			}	
			if(null!=req.getParameter("changeLastnameCheck")) {
				change.changeLastName(req.getParameter("changeLastname"), Integer.parseInt(session.getAttribute("userId").toString()));
			}	
			if(null!=req.getParameter("changePasswordCheck")) {
				change.changePassword(req.getParameter("changePassword"), Integer.parseInt(session.getAttribute("userId").toString()));
			}	
			if(null!=req.getParameter("changeEmailCheck")) {
				change.changeEmail(req.getParameter("changeEmail"), Integer.parseInt(session.getAttribute("userId").toString()));
			}	
		
		req.getRequestDispatcher("Profile.html").forward(req, resp);

	}

}
