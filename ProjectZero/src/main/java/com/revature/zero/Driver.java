package com.revature.zero;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.SuperUser;
import com.revature.dao.TransactionDAOImpl;
import com.revature.exceptions.OverdraftException;

public class Driver {
	public static void main(String[] args) throws OverdraftException {
		Prints.print();
		// helper Classes
		AccountDAOImpl acc = new AccountDAOImpl();
		SuperUser acc2 = new SuperUser();
		TransactionDAOImpl trans = new TransactionDAOImpl();

		User user = new User();
		Account account = new Account();
		// Primitives
		int accountID = -1, action, userID = 0;
		double money = 0;
		String moreActions;
		boolean loggedin = false;

		// username input
		Scanner userIn = new Scanner(System.in);
		System.out.println("Login or press enter to make a new user");
		String username = userIn.nextLine();
		while (!loggedin) {
			if (username.isEmpty()) {
				userID = acc.makeUser();
			} else if (acc.usernameExists(username)) {
				System.out.println("Enter password");
				String password = userIn.nextLine();
				if (-1 != acc.passwordMatches(username, password)) {
					userID = acc.getUser(username, password);
					user.setPassword(password);
					user.setUsername(username);
					user.setUserID(userID);
					loggedin = true;
				} else {
					System.out.println("Password does not match username");
					System.out.println("Login or press enter to make a new account");
					username = userIn.nextLine();
				}
			} else {
				System.out.println("Username you entered does not exist");
				System.out.println("Login or press enter to make a new account");
				username = userIn.nextLine();
			}

		}
		System.out.println("Would you like to make a new account?(y/n)");
		moreActions = userIn.nextLine();
		if (moreActions.equals("y")) {
			acc.addAccount(user.getUserID());
		}
		System.out.println("What account would you like to see?");
		acc.getAccounts(user.getUserID());
		accountID = userIn.nextInt();
		account.setAccountID(accountID);
		moreActions = "y";
		
		while (moreActions.equals("y") || moreActions.equals("Y")) {

			if (user.getUserID() == 1022) {

				System.out.println(
						"What action would you like to do? \n(1) Deposit,\n(2) Withdraw,\n(3) Check balance,\n(4) Logout \n(5) Delete account\n"
								+ "(6) See all account\n(7) Delete any account \n(8) Create a new account for a user");
				action = userIn.nextInt();
			} else {
				System.out.println(
						"What action would you like to do? (1)Deposit,(2) Withdraw, (3) Check balance, (4)Logout, (5) Delete account");
				action = userIn.nextInt();
			}
			moreActions = "y";
			switch (action) {
			case 1:
				System.out.println("How much?");
				money = userIn.nextDouble();
				trans.deposit(user.getUserID(), accountID, money);
				break;
			case 2:
				System.out.println("How much?");
				money = userIn.nextDouble();
				trans.withdraw(user.getUserID(), accountID, money);
				break;
			case 3:
				trans.getBalance(user.getUserID(), accountID);
				break;
			case 4:
				acc = null;// log out
				break;
			case 5:
				if (trans.getBalance(user.getUserID(), accountID) == 0) {
					acc.deleteAccount(user.getUserID(), accountID);
					break;
				}

				else
					System.out.println("Balance isn't zero");
				break;
			case 6:
				acc2.getAccounts(user.getUserID());
				break;
			case 7:
				acc2.deleteAccount(user.getUserID(), accountID);
				break;
			case 8:
				acc2.getAccounts(user.getUserID());
				break;
			default:
				System.out.println("Bad input try again?(y/n)");
				break;
			}
			System.out.println("More actions? (y/n)");
			moreActions = userIn.next();
			if (!moreActions.equals("y")) {
				System.out.println("Goodbye!");
			}
		}

		// system.in match password()
		userIn.close();

	}
}