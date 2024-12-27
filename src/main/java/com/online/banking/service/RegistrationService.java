package com.online.banking.service;

import java.util.List;

import com.online.banking.entities.Registration;

public interface RegistrationService {
	public boolean addNewUser(Registration registration);

	public List<Registration> getAllUsers();

	Registration login(String username, String password, String type);

	boolean validateBankLogin(String username, String password);

	boolean validateCustomerLogin(String username, String password);

}
