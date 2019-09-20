package com.revature.dao;

import com.revature.exceptions.OverdraftException;

public interface TransactionDAO {
	public int deposit(int userID, int accountID, double money);

	public int withdraw(int userID, int accountID, double money) throws OverdraftException;

	public double getBalance(int userID, int accountID);

}
