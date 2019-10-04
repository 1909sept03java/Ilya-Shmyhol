package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;



public interface ReimbursementDAO {
	public List<Reimbursement> getReimbursements();

	public List<Reimbursement> getReimbursementsOfEmployee(int employeeId);
	
	public void createReimbursements(double balance, int employeeId);

}
