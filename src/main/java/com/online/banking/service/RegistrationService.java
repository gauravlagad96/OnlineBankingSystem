package com.online.banking.service;

import java.util.List;

import com.online.banking.entities.Registration;

public interface RegistrationService {
	public boolean addNewUser(Registration registration);
	public List<Registration> getAllUsers();

}


