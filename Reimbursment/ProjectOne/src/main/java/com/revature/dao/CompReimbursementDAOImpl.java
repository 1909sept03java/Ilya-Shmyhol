package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.service.ConnectionService;

public class CompReimbursementDAOImpl {

	public List<Reimbursement> getCompReimbursementsOfEmployee(int employeeId) {
		System.out.println(employeeId);
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM RESOLVED_REIMBURSEMENTS WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			// System.out.println(reimList.toString());
			System.out.println("Here");
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				double reimbursementBalance = rs.getDouble("BALANCE");
				reimList.add(new Reimbursement(reimbursementId, reimbursementBalance, employeeId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimList;
	}
	public List <Reimbursement> getCompReimbursementsOfAllEmployees(){
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM RESOLVED_REIMBURSEMENTS";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//System.out.println(reimList.toString());
			while (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");

				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				double reimbursementBalance = rs.getDouble("BALANCE");
				reimList.add(
						new Reimbursement(reimbursementId, reimbursementBalance, employeeId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimList;
	}
}
