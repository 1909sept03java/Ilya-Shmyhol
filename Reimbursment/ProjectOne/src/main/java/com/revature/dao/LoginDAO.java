package com.revature.dao;


public interface LoginDAO {
	public int passwordMatches(String username2, String password2);
	public Object getInfo(int id);

}
