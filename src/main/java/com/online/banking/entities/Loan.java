package com.online.banking.entities;

public class Loan {
	private int loanId;
	private int userId;
	private double loanAmount;
	private String loanType;
	private String status;
	private String appliedDate;

	// Constructors
	public Loan() {
	}

	public Loan(int loanId, int userId, double loanAmount, String loanType, String status, String appliedDate) {
		this.loanId = loanId;
		this.userId = userId;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
		this.status = status;
		this.appliedDate = appliedDate;
	}

	// Getters and Setters
	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(String appliedDate) {
		this.appliedDate = appliedDate;
	}
}
