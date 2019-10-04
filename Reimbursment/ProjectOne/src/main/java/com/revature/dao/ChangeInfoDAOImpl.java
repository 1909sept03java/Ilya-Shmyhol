package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.service.ConnectionService;

public class ChangeInfoDAOImpl {


	public void changeFirstName(String firstname, int id) {
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "UPDATE EMPLOYEES SET FIRSTNAME=? WHERE EMPLOYEE_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void changeLastName(String lastname, int id) {
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "UPDATE EMPLOYEES SET LASTNAME=? WHERE EMPLOYEE_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, lastname);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void changePassword(String password, int id) {
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "UPDATE EMPLOYEES SET PASSWORDS=? WHERE EMPLOYEE_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeEmail(String email, int id) {
		try (Connection con = ConnectionService.getConnection();) {
			String sql = "UPDATE EMPLOYEES SET EMAIL=? WHERE EMPLOYEE_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, id);
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
