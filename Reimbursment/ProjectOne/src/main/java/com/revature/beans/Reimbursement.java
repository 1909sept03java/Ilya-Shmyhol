package com.revature.beans;

public class Reimbursement {

	int reimbursementId;
	double reimbursementBalance;
	int employeeId;

	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimbursementId, double reimbursementBalance, int employeeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementBalance = reimbursementBalance;
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Reimbursements [reimbursementId=" + reimbursementId + ", reimbursementBalance=" + reimbursementBalance
				+ ", employeeId=" + employeeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		long temp;
		temp = Double.doubleToLongBits(reimbursementBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbursementId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (employeeId != other.employeeId)
			return false;
		if (Double.doubleToLongBits(reimbursementBalance) != Double.doubleToLongBits(other.reimbursementBalance))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;

		return true;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public double getReimbursementBalance() {
		return reimbursementBalance;
	}

	public void setReimbursementBalance(double reimbursementBalance) {
		this.reimbursementBalance = reimbursementBalance;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}