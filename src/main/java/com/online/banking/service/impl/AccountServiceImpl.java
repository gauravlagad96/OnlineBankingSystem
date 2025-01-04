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
	public BigDecimal viewBalance(String accountNumber) {
	    return accountDao.viewBalance(accountNumber); // Pass the accountNumber to DAO
	}
	
	@Override
	public void deposit(String accountNumber, BigDecimal amount) {
	    accountDao.deposit(accountNumber, amount); // Forward request to DAO
	}
	
	@Override
	public void withdraw(String accountNumber, BigDecimal amount) {
	    // Validate withdrawal amount
	    if (amount.compareTo(BigDecimal.ZERO) <= 0) {
	        throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
	    }

	    // Call DAO to perform the withdrawal
	    accountDao.withdraw(accountNumber, amount);
	}

	@Override
	public void transferMoney(String sourceAccountNumber, String destinationAccountNumber, BigDecimal amount) {
	    // Validate transfer amount
	    if (amount.compareTo(BigDecimal.ZERO) <= 0) {
	        throw new IllegalArgumentException("Transfer amount must be greater than zero.");
	    }

	    // Delegate the transfer logic to the DAO layer
	    accountDao.transferMoney(sourceAccountNumber, destinationAccountNumber, amount);
	}


}
