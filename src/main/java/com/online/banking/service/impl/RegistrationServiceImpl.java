package com.online.banking.service.impl;

import java.util.List;

import com.online.banking.dao.RegistrationDao;
import com.online.banking.dao.impl.RegistrationDaoImp;
import com.online.banking.entities.Registration;
import com.online.banking.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

	RegistrationDao regRepo = new RegistrationDaoImp();

	@Override
	public boolean addNewUser(Registration registration) {
		return regRepo.addNewUser(registration);
	}

	@Override
	public List<Registration> getAllUsers() {
		return regRepo.getAllUsers();
	}

}
