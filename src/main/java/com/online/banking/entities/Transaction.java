package com.online.banking.entities;

public class Transaction {
	private int transactionId;
	private int accountId;
	private int destinationAccountId;
	private double amount;
	private String transactionType;
	private String transactionDate;
	private String remarks;

	// Constructors
	public Transaction() {
	}

	public Transaction(int transactionId, int accountId, int destinationAccountId, double amount,
			String transactionType, String transactionDate, String remarks) {
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.destinationAccountId = destinationAccountId;
		this.amount = amount;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.remarks = remarks;
	}

	//  Getters and Setters

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getDestinationAccountId() {
		return destinationAccountId;
	}

	public void setDestinationAccountId(int destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
