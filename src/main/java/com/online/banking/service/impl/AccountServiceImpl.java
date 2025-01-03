package com.online.banking.service.impl;

import java.math.BigDecimal;

import com.online.banking.dao.AccountDao;
import com.online.banking.dao.impl.AccountDaoImpl;
import com.online.banking.entities.Account;
import com.online.banking.service.AccountService;

public class AccountServiceImpl implements AccountService {

	AccountDao accountDao = new AccountDaoImpl();

	@Override
	public void createAccount(Account account) {
		accountDao.createAccount(account);
	}

	@Override
	public void viewBalance(BigDecimal balance) {
		accountDao.viewBalance(balance);
	}

	
}
