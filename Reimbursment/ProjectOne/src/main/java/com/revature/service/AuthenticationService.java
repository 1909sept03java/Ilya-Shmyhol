package com.revature.service;

import com.revature.beans.EmployeeCredentials;
import com.revature.beans.EmployeeInfo;
import com.revature.dao.LoginDAOImpl;

public class AuthenticationService {
	
	// if credentials are not recognized, return null
	// if they are, return user associated with them
	public EmployeeInfo authenticateUser(EmployeeCredentials creds) {
		LoginDAOImpl login = new LoginDAOImpl();
		EmployeeInfo u = null;
		int empID=login.passwordMatches(creds.getUsername(), creds.getPassword());
		
		if (empID!=-1) {
			u = login.getInfo(empID);
		}
		return u;
	}

}