package com.online.banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary {
	private int beneficiaryId;
	private int userId;
	private String beneficiaryAccountNumber;
	private String beneficiaryName;
	private String createdAt;

}
