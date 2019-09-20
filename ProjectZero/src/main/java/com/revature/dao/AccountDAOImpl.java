package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.exceptions.OverdraftException;
import com.revature.zero.ConnectionUtil;

public class AccountDAOImpl {// extends MyExceptions {

	public int makeUser() {
		String username;
		String password;
		int userID = -1;
		int flag = 0;

		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter a new username with 6-12 letters and/or numbers");

		username = myScanner.nextLine();

		do {
			if (!valUsername(username)) {

				flag = 1;
				System.out.println(
						"Your selected username is already in use or uses a special charcter, please try another one");
				username = myScanner.nextLine();
			} else
				flag = 0;
		} while (flag == 1);

		System.out.println("Please select a password");
		password = myScanner.nextLine();
		do {
			if (!valPassword(password)) {
				System.out.println("Your selected password uses a special charcter, please try another one");
				password = myScanner.nextLine();
				flag = 1;
			} else
				flag = 0;
		} while (flag == 1);

		enterNewUserIntoSQL(username, password);
		// myScanner.close();
		return 0;

	}

//----------------------------------------------------------------------------------------------------------------------------------------
	private void enterNewUserIntoSQL(String username, String password) {

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO USERS_(USERNAME, PASSWORD) VALUES(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your account has been made, please login");

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
			String sql = "SELECT * FROM USERS_ WHERE USERNAME=?";
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
			String sql = "SELECT * FROM USERS_ WHERE PASSWORD=? AND USERNAME=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(2, username2);
			pstmt.setString(1, password2);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				// throw MyException;
			}
			userID = rs.getInt("USER_ID");

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

	public int getUser(String username2, String password2) {
		// TODO validadetes that the account match exists and returns the cryptic id
		return passwordMatches(username2, password2);
	}

	public void getAccounts(int id) {
		int x = 0;
		try (Connection con = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				x = rs.getInt("ACCOUNT_ID");
				System.out.println("Account ID: " + x);
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addAccount(int userID) {
		try (Connection con = ConnectionUtil.getConnection()) {

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

	public void deleteAccount(int userID, int accountID) {


		try (Connection con = ConnectionUtil.getConnection()) {
			if (accountID == 1022) {
				String sql = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID=?";

				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, accountID);
				pstmt.executeUpdate();
			} else {
				String sql = "DELETE FROM ACCOUNTS WHERE USER_ID=? AND ACCOUNT_ID=? ";

				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, userID);
				pstmt.setInt(2, accountID);
				pstmt.executeUpdate();
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
