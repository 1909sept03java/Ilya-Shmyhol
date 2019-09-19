package com.revature.zero;

import java.util.Scanner;

import com.revature.dao.AccountDAOImpl;


public class Driver {
	public static void main(String[] args) {

		// helper Class
		AccountDAOImpl acc = new AccountDAOImpl();

		// Primitives
		int accountID = -1, action;
		Boolean moreActions = false;

		// username input
		Scanner userIn = new Scanner(System.in);
		System.out.println("Login or press enter to make a new account");
		String username = userIn.nextLine();

		if (username.isEmpty()) {
			accountID = acc.makeAccount();
		} else if (acc.usernameExists(username)) {
			System.out.println("Enter password");
			String password = userIn.nextLine();
			if (-1!=acc.passwordMatches(username, password)) {
				accountID = acc.getAccount(username, password);
			}
		}
	
		// set in our DAO

		/*
		 * do { System.out.
		 * println("What action would you like to do? (1)Deposit,(2) Withdraw, (3) Check balance, (4) logout"
		 * );
		 * 
		 * switch(action) { case 1: case 2: case 3: case 4: default: } }
		 * while(moreActions);
		 */
		// system.in match password()

	}
}