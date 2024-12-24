package com.online.banking.service;

import java.util.List;

import com.online.banking.entities.Loan;

public interface LoanService {
	boolean applyForLoan(Loan loan);

	List<Loan> getLoansByUserId(int userId);

	boolean updateLoanStatus(int loanId, String status);
}