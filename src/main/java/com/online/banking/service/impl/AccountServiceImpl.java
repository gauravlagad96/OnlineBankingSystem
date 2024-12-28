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
	public Account getAccountById(int accountId) {
		return accountDao.getAccountById(accountId);
	}

	@Override
	public void deposit(int accountId, BigDecimal amount) {
		Account account = getAccountById(accountId);
		account.setBalance(account.getBalance().add(amount));
		accountDao.updateBalance(accountId, account.getBalance());
	}

	@Override
	public void withdraw(int accountId, BigDecimal amount) {
		Account account = getAccountById(accountId);
		if (account.getBalance().compareTo(amount) < 0) {
			throw new RuntimeException("Insufficient funds");
		}
		account.setBalance(account.getBalance().subtract(amount));
		accountDao.updateBalance(accountId, account.getBalance());
	}

}
