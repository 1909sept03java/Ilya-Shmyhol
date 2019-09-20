package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.zero.ConnectionUtil;

public class SuperUser extends AccountDAOImpl{
	public void addAccount(int userID) {
		if (userID != 1022)
			return;
		Scanner adminIn = new Scanner(System.in);

		try (Connection con = ConnectionUtil.getConnection()) {
			System.out.println("Enter the USER_ID you would like to make a new account for");
			userID = adminIn.nextInt();
			String sql = "INSERT  INTO  ACCOUNTS(USER_ID, BALANCE) VALUES(?,?) ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userID);
			pstmt.setInt(2, 0);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getAccounts(int id) {
		if (id != 1022)
			return;
		Scanner adminIn = new Scanner(System.in);

		int x = 0;
		try (Connection con = ConnectionUtil.getConnection()) {
			System.out.println("Enter the USER_ID you would like to make a new account for");
			id = adminIn.nextInt();
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				x = rs.getInt("ACCOUNT_ID");
				System.out.println("Account ID: " + x);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
