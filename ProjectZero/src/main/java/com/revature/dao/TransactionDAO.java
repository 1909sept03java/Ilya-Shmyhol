package com.revature.dao;

public interface TransactionDAO {
	int deposit(int userID,int accountID);
	
	int withdraw(int userID,int accountID);
	
	int getBalance(int userID,int accountID);
}
