package com.online.banking.service;

import java.util.List;

import com.online.banking.entities.Beneficiary;

public interface BeneficiaryService {
	boolean addBeneficiary(Beneficiary beneficiary);

	List<Beneficiary> getBeneficiariesByUserId(int userId);

	boolean deleteBeneficiary(int beneficiaryId);
}