package com.online.banking.service;

import java.util.List;

import com.online.banking.entities.Transaction;

public interface TransactionService {
	boolean createTransaction(Transaction transaction);

	Transaction getTransactionById(int transactionId);

	List<Transaction> getTransactionsByAccountId(int accountId);
}
