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

public class ReimbursementDAOImpl implements ReimbursementDAO {

	public void approveReimbursements(int reimbursementId, int mangId) {
		try (Connection con = ConnectionService.getConnection();) {
			int employeeId = 0;
			double reimbursementBalance = 0;

			String sql = "SELECT * FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reimbursementId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimbursementBalance = rs.getDouble("BALANCE");
				employeeId = rs.getInt("EMPLOYEE_ID");
			}

			sql = "INSERT INTO RESOLVED_REIMBURSEMENTS(REIMBURSEMENT_ID, BALANCE, EMPLOYEE_ID, RESOLVED_BY ) VALUES(?,?,?,?) ";
			PreparedStatement ps2 = con.prepareStatement(sql);
			System.out.println(reimbursementBalance+ " id"+reimbursementId);
			ps2.setDouble(2, reimbursementBalance);
			ps2.setInt(3, employeeId);
			ps2.setInt(4, mangId);
			ps2.setInt(1, reimbursementId);

			ps2.executeUpdate();
			
			sql= "DELETE FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID=?";
			PreparedStatement ps3 = con.prepareStatement(sql);
			ps3.setInt(1, reimbursementId);
			ps3.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Reimbursement> getAllReimbursements() {

		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM REIMBURSEMENT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENT_ID");
				double reimbursementBalance = rs.getDouble("BALANCE");
				int employeeId = rs.getInt("EMPLOYEE_ID");
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

	public List<Reimbursement> getReimbursementsOfEmployee(int employeeId) {
		System.out.println(employeeId);
		List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			// System.out.println(reimList.toString());
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

	public void createReimbursements(double balance, int employeeId) {
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "INSERT INTO REIMBURSEMENT(BALANCE, EMPLOYEE_ID) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setInt(2, employeeId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
