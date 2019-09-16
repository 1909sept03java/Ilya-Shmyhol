package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class DeptNameAndSalary {
	private void getDeptNameAndSalary() {
		try(Connection conn= ConnectionUtil.getConnection()){
			String sql=	"SELECT DEPARTMENTS.DEPARTMENT_ID, EMPLOYEES.SALARY, DEPARTMENTS.DEPARTMENT_NAME FROM DEPARTMENTS LEFT OUTER JOIN EMPLOYEES ON DEPARTMENTS.DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID GROUP BY DEPARTMENTS.DEPARTMENT_ID, employees.salary, DEPARTMENTS.DEPARTMENT_NAME ORDER BY DEPARTMENTS.DEPARTMENT_ID;\r\n" + 
					
			PreparedStatement stmt=conn.prepareStatement(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	
	
}
				