import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

public class testDAOMethods {


	
	@Test
	public static void testchangeReimburstment() {
		try (Connection conn = connectionutil.getConnection()) {
			String sqlplus = "Select * FROM REIMBURSEMENT WHERE REIMBURSTMENT_ID = "+12;	
			Statement sm = conn.createStatement();
			ResultSet rs = sm.executeQuery(sqlplus);

			employeeInfo us;
			int EMP_ID = 0;
			while (rs.next()) {
				EMP_ID = rs.getInt("EMP_ID");
			}
			if(EMP_ID!= 0) {
				sqlplus = "Select * FROM EMPLOYEE WHERE EMPLOYEE_ID = "+EMP_ID;
				Statement sm1 = conn.createStatement();
				ResultSet rs1 = sm1.executeQuery(sqlplus);	
				int EMP_MAN=0;
				while (rs1.next()) {
					EMP_MAN = rs1.getInt("EMP_MAN");
				}
				
				assertEquals(EMP_MAN,101);
			}
			
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public static void testEmployeeReimbursment() {
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		ArrayList<Integer> usid = new ArrayList<Integer>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sqlplus = "Select * FROM EMPLOYEE WHERE EMP_MAN=101 " ;
			Statement sm = conn.createStatement();
			ResultSet rs = sm.executeQuery(sqlplus);
			while (rs.next()) {
				int empid = rs.getInt("EMPLOYEE_ID");
				usid.add(empid);
			}
			for(int i : usid) {
				 sqlplus = "Select * FROM REIMBURSEMENT WHERE EMP_ID= " + i;
				 rs = sm.executeQuery(sqlplus);
				while (rs.next()) {
					int id = rs.getInt("RE_ID");
					double money = rs.getDouble("AMOUNT");
					int s = rs.getInt("STATUS");
					boolean status=false;
					if (s>0)
						status =true;
					r.add(new Reimburse(id, money, status,"un"));
				}
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(r.get(0).getId(),12);
	}
	public static void changePassword() {
		int user = 102;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sqlplus = " update EMPLOYEE SET EMP_PASSWORD=? WHERE EMPLOYEE_ID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(sqlplus);
			preparedStmt.setString(1, "test");
			preparedStmt.setInt(2, user);

			preparedStmt.execute();

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addReimbursment() {
		int user = 102;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sqlplus = " insert into REIMBURSEMENT (EMP_ID, AMOUNT)" + " values (?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(sqlplus);
			preparedStmt.setInt(1, user);
			preparedStmt.setDouble(2, 100);
			preparedStmt.execute();

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}}
