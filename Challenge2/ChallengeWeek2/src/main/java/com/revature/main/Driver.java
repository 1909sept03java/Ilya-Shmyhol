package com.revature.main;

import java.sql.Connection;

public class Driver {

	public static void main(String[] args) {
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			System.out.println(conn);
			System.out.println(conn.getMetaData().getDatabaseMajorVersion());
		} catch(Exception e) {
			e.printStackTrace();	
		}
		
		
		
	}

}