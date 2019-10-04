package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDAOImpl;

@WebServlet("/createReim")
public class CreateReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 8963444282420917325L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		ReimbursementDAOImpl reim = new ReimbursementDAOImpl();

		System.out.println(Double.parseDouble(req.getParameter("reimBal")));
		System.out.println(Integer.parseInt(session.getAttribute("userId").toString()));
		reim.createReimbursements(Double.parseDouble(req.getParameter("reimBal")),
				Integer.parseInt(session.getAttribute("userId").toString()));
			//System.out.println("EMPLOYEE ENTERED");
			req.getRequestDispatcher("Profile.html").forward(req, resp);
		
	}

}
