package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.exceptions.MyExceptions;
import com.revature.zero.ConnectionUtil;

public class AccountDAOImpl {// extends MyExceptions {

	public int makeAccount() {
		String username;
		String password;
		int flag = 0;

		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter a new username with 6-12 letters and/or numbers");
		
		username = myScanner.nextLine();
		System.out.println("here");
		username = myScanner.nextLine();
		/*do {
			if (!valUsername(username)) {

				
				flag=1;
				System.out.println(
						"Your selected username is already in use or uses a special charcter, please try another one");
				username = myScanner.nextLine();
			}
		} while (flag == 1);
		flag=0;
		System.out.println("Please select a password");
		password = myScanner.nextLine();
		do {
			
			System.out.println("Your selected password uses a special charcter, please try another one");
			password = myScanner.nextLine();
			
		}while (!valPassword(password));*/
		
		//enterNewUserIntoSQL(username, password);
		return 0;
	}

	private void enterNewUserIntoSQL(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("here");
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO ACCOUNTS(USERNAME, PASSWORD) VALUES(?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean valUsername(String username) {
		// TODO NOT SURE?
		if (!usernameExists(username)) {
			return username.matches("[a-zA-Z0-9]+");
		} else
			return false;

	}

	private boolean valPassword(String password) {
		if (password.matches("[a-zA-Z0-9]+"))
			return true;
		else
			return false;

	}

	public Boolean usernameExists(String username2) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username2);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public int passwordMatches(String username2, String password2) {
		int userID = -1;
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EMPLOYEE WHERE PASSWORD=? AND USERNAME=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(2, username2);
			pstmt.setString(1, password2);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				// throw MyException;
			}
			userID = rs.getInt("ACCOUNT_ID");

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userID;
		// TODO:checks if the password is in the database

	}

	public int getAccount(String username2, String password2) {
		// TODO validadetes that the account match exists and returns the cryptic id

		return 0;
	}

}
