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
import com.revature.beans.EmployeeInfo;
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAOImpl;

@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = -2809114045100085073L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {

			EmployeeCredentials cred = new EmployeeCredentials();

			EmployeeInfo emp = new EmployeeInfo();

			emp.setId(Integer.parseInt(session.getAttribute("userId").toString()));
			cred.setUsername(session.getAttribute("username").toString());
			cred.setPassword(session.getAttribute("password").toString());
			emp.setEmail(session.getAttribute("email").toString());

			ReimbursementDAOImpl reimburstment = new ReimbursementDAOImpl();
			List<Reimbursement> reimbList = reimburstment.getReimbursementsOfEmployee(emp.getId());
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
