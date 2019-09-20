package com.revature.dao;

import java.io.IOException;
import com.revature.exceptions.OverdraftException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.zero.ConnectionUtil;

public class TransactionDAOImpl implements TransactionDAO {

	public int deposit(int userID, int accountID, double money) {
		double balance = 0;
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID=? AND ACCOUNT_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userID);
			pstmt.setInt(2, accountID);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				// throw MyException;
			}
			balance = rs.getDouble("BALANCE");

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		balance += money;
		try (Connection con = ConnectionUtil.getConnection()) {

			String sql = "UPDATE ACCOUNTS SET BALANCE=? WHERE ACCOUNT_ID=?  ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(2, 11);
			pstmt.setDouble(1, 5);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	

	public int withdraw(int userID, int accountID, double money)throws OverdraftException {
		double balance = -1;
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID=? AND ACCOUNT_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userID);
			pstmt.setInt(2, accountID);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				// throw MyException;
			}
			balance = rs.getDouble("BALANCE");

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (balance - money < 0) {
			throw new OverdraftException();
		} else
			balance -= money;
		try (Connection con = ConnectionUtil.getConnection()) {

			String sql = "UPDATE ACCOUNTS SET BALANCE=? WHERE ACCOUNT_ID=?  ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(2, 11);
			pstmt.setDouble(1, 5);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public double getBalance(int userID, int accountID) {
		double balance = -1;
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID=? AND ACCOUNT_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userID);
			pstmt.setInt(2, accountID);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				// throw MyException;
			}
			balance = rs.getDouble("BALANCE");
			System.out.println("Your balance is : $"+balance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balance;
	}

	

}
