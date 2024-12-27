package com.online.banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	private int accountId;
	private int userId;
	private String accountNumber;
	private String accountType;
	private double balance;
	private String createdAt;
	
}
