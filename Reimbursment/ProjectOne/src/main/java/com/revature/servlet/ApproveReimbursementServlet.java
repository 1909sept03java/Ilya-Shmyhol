package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDAOImpl;

@WebServlet("/approveReim")
public class ApproveReimbursementServlet extends HttpServlet{
	private static final long serialVersionUID = 7108909978114842186L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		ReimbursementDAOImpl reim = new ReimbursementDAOImpl();

		System.out.println(Double.parseDouble(req.getParameter("reimId")));
		System.out.println(Integer.parseInt(session.getAttribute("mangId").toString()));
		
		reim.approveReimbursements(Integer.parseInt(req.getParameter("remId")),
				Integer.parseInt(session.getAttribute("mangId").toString()));
			req.getRequestDispatcher("ManagerProfile.html").forward(req, resp);
		
	}

}
