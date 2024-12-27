package com.online.banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	private int transactionId;
	private int accountId;
	private int destinationAccountId;
	private double amount;
	private String transactionType;
	private String transactionDate;
	private String remarks;

}
