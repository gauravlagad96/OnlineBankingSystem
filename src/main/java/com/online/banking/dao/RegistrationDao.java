package com.online.banking.dao;

import java.util.List;

import com.online.banking.entities.Registration;

public interface RegistrationDao {

	public boolean addNewUser(Registration registration);
	public List<Registration> getAllUsers();
    Registration login(String username, String password, String type); // Login method

	
}
