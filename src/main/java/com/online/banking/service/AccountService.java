package com.online.banking.service;

import java.math.BigDecimal;
import java.util.List;

import com.online.banking.entities.Account;

public interface AccountService {
	void createAccount(Account account);
	void viewBalance(BigDecimal balance);
	

}