package com.online.banking.entities;

import java.math.BigDecimal;

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
	private BigDecimal amount;
	private String transactionType;
	private String transactionDate;
	private String remarks;

}
