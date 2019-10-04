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
import com.revature.beans.Reimbursement;
import com.revature.dao.CompReimbursementDAOImpl;

@WebServlet("/completedreimbursement")

public class CompReimbursementServlet  extends HttpServlet {

	private static final long serialVersionUID = -2809114045100085073L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {

			
			CompReimbursementDAOImpl comp = new CompReimbursementDAOImpl();
			List<Reimbursement> reimbList = comp.getCompReimbursementsOfEmployee(Integer.parseInt(session.getAttribute("userId").toString()));
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
