package com.online.banking.dao.impl;

import com.online.banking.dao.DbState;
import com.online.banking.dao.RegistrationDao;
import com.online.banking.entities.Registration;

import java.util.ArrayList;
import java.util.List;

import com.online.*;

public class RegistrationDaoImp extends DbState implements RegistrationDao {

	@Override
	public boolean addNewUser(Registration registration) {

		try {
			String sql = "INSERT INTO registration (reg_id, username, password, email, phone_number, user_type) "
					+ "VALUES ('0', ?, ?, ?, ?, ?)";
			preStmt = connection.prepareStatement(sql);
			preStmt.setString(1, registration.getUsername());
			preStmt.setString(2, registration.getPassword());
			preStmt.setString(3, registration.getEmail());
			preStmt.setString(4, registration.getPhoneNumber());
			preStmt.setString(5, registration.getType());

			int result = preStmt.executeUpdate();

			return result > 0 ? true : false;

		} catch (Exception e) {
			System.out.println("error is  : " + e);
			return false;
		}
	}

	@Override
	public List<Registration> getAllUsers() {
		List<Registration> users = new ArrayList<>();
		try {

			String sql = "select * from registration";
			preStmt = connection.prepareStatement(sql);
			resultSet = preStmt.executeQuery();

			while (resultSet.next()) {
				Registration reg = new Registration();
				reg.setUserId(resultSet.getInt("reg_id"));
				reg.setUsername(resultSet.getString("username"));
				reg.setPassword(resultSet.getString("password"));
				reg.setEmail(resultSet.getString("email"));
				reg.setPhoneNumber(resultSet.getString("phone_number"));
				reg.setType(resultSet.getString("user_type"));

				// Add the user to the list
				users.add(reg);
			}

		} catch (Exception e) {
			System.out.println("Error is : " + e);
		}

		return users;
	}

	@Override
	public Registration login(String username, String password, String type) {
		String sqlQuery = "select * from registration where username=? and password=? and user_type=?";
		try {

			preStmt = connection.prepareStatement(sqlQuery);
			preStmt.setString(1, username);
			preStmt.setString(2, password);
			preStmt.setString(3, type);

			resultSet = preStmt.executeQuery();

			if (resultSet.next()) {
				Registration user = new Registration();
				user.setUsername(username);
				user.setPassword(password);
				user.setType(type);

				return user;
			}
		} catch (Exception e) {
			System.out.println("Error is : " + e);
		}
		
		return null;
	}

}
