package com.online.banking.entities;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cards {
	private int cardId;
	private int regId;
	private String cardNumber;
	private String cardType;    // Example:'debit', 'credit'
	private LocalDate expiryDate;
	private Timestamp createdAt;

}
