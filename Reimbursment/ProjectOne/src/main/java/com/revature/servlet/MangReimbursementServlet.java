package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.EmployeeCredentials;
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAOImpl;

@WebServlet("/mangreimbursement")
public class MangReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3145670866225003238L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		try {

			EmployeeCredentials cred = new EmployeeCredentials();

			
			ReimbursementDAOImpl reimburstment = new ReimbursementDAOImpl();
			List<Reimbursement> reimbList = reimburstment.getAllReimbursements();
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(reimbList));

		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
