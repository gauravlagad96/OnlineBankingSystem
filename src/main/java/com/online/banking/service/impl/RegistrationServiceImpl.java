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

	@Override
	public Registration login(String username, String password, String type) {
		// TODO Auto-generated method stub
		return regRepo.login(username, password, type);
	}

	@Override
	public boolean validateBankLogin(String username, String password) {
		Registration bankUser= regRepo.login(username, password, "bank");
		
		return bankUser!=null;// return true if bank user exists.
	}

	@Override
	public boolean validateCustomerLogin(String username, String password) {
		 Registration customerUser = regRepo.login(username, password, "customer");
		return customerUser!=null; //return true id customerUser in found otherwise false!
	}
	

}
