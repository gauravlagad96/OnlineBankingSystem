package com.online.banking.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	private int accountId;
	private int regId;
	private String accountNumber;
	private String accountType;
	private BigDecimal balance;
	private String createdAt;
	
}
