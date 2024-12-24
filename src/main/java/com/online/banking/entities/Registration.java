package com.online.banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private String createdAt;
	private String type;

}
