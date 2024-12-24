package com.online.banking.entities;

public class Beneficiary {
	private int beneficiaryId;
	private int userId;
	private String beneficiaryAccountNumber;
	private String beneficiaryName;
	private String createdAt;

	// Constructors
	public Beneficiary() {
	}

	public Beneficiary(int beneficiaryId, int userId, String beneficiaryAccountNumber, String beneficiaryName,
			String createdAt) {
		this.beneficiaryId = beneficiaryId;
		this.userId = userId;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.beneficiaryName = beneficiaryName;
		this.createdAt = createdAt;
	}

	// Getters and Setters
	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
