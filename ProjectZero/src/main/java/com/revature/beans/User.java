package com.revature.beans;

public class User {
	public User() {
		super();
	}
	public User(String username, String password, int userID) {
		super();
		this.username=username;
		this.password=password;
		this.userID=userID;
	}
	
	private String username;
	private String password;
	private int userID;
	public void setUserID(int userID) {
		this.userID=userID;
	}
	public int getUserID(){
		return userID;
		
	}
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}

	public void setPassword(String newPassword) {
		this.password = newPassword;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
