package com.online.banking.dao;

import java.math.BigDecimal;

import com.online.banking.entities.Account;

public interface AccountDao {

	void createAccount(Account account);
	void viewBalance(BigDecimal balance);
	

}
