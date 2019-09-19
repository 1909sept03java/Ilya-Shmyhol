package com.revature.zero;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException, IOException {
		// read in contents of a properties file - NEVER want to hardcode credentials
		String file="src/main/resources/connection.properties";
		Properties prop = new Properties();
		InputStream in=new FileInputStream(file);	
		prop.load(in);
		// InputStream in = new FileInputStream("connection.properties");
		//prop.load(ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties"));
		// need to provide: url to the database, username, password
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}


}