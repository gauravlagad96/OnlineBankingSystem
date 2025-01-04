package com.online.banking.dao;

import java.math.BigDecimal;

import com.online.banking.entities.Account;

public interface AccountDao {

	void createAccount(Account account);

	public BigDecimal viewBalance(String accountNumber);

	public void deposit(String accountNumber, BigDecimal amount);

	public void withdraw(String accountNumber, BigDecimal amount);

	public void transferMoney(String sourceAccountNumber, String destinationAccountNumber, BigDecimal amount);
}
