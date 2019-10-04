package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.EmployeeInfo;
import com.revature.service.ConnectionService;

public class LoginDAOImpl implements LoginDAO {
	public int passwordMatches(String username2, String password2) {
		int userID = -1;
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEES WHERE PASSWORDS=? AND USERNAME=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(2, username2);
			pstmt.setString(1, password2);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				
				return -1;
			}
			userID = rs.getInt("EMPLOYEE_ID");

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userID;

	}

	public EmployeeInfo getInfo(int id) {
		EmployeeInfo employee = new EmployeeInfo();
		try (Connection con = ConnectionService.getConnection()) {

			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				employee.setId(rs.getInt("EMPLOYEE_ID"));
				employee.setMangId(rs.getInt("MANAGER_ID"));
				employee.setFirstname(rs.getString("FIRSTNAME"));
				employee.setLastname(rs.getString("LASTNAME"));
				employee.setEmail(rs.getString("EMAIL"));
				//TODO return null and handle if this condition doesn't work 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
}
