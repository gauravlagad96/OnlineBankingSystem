package com.online.banking.service;

import java.math.BigDecimal;
import java.util.List;

import com.online.banking.entities.Account;

public interface AccountService {
	void createAccount(Account account);

	Account getAccountById(int accountId);

	void withdraw(int accountId, BigDecimal amount);

	void deposit(int accountId, BigDecimal amount);

}