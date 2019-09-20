package com.revature.dao;

public interface AccountDAO {
	public int makeUser();

	void enterNewUserIntoSQL(String username, String password);

	public boolean valUsername(String username);

	boolean valPassword(String password);

	public Boolean usernameExists(String username2);

	public int passwordMatches(String username2, String password2);

	public int getUser(String username2, String password2);

	public void getAccounts(int id);

}
