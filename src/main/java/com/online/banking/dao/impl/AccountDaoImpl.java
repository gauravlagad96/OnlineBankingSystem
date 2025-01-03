package com.online.banking.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.online.banking.dao.AccountDao;
import com.online.banking.dao.DbState;
import com.online.banking.entities.Account;

public class AccountDaoImpl extends DbState implements AccountDao {

	@Override
	public void createAccount(Account account) {
		String query = "INSERT INTO Accounts (reg_id, account_number, account_type, balance) VALUES (?, ?, ?, ?)";
		try {
			preStmt = connection.prepareStatement(query);

			preStmt.setInt(1, account.getRegId());
			preStmt.setString(2, account.getAccountNumber());
			preStmt.setString(3, account.getAccountType());
			preStmt.setBigDecimal(4, account.getBalance()); // Use setBigDecimal for BigDecimal
			preStmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error is : " + ex);
		}
	}

	@Override
	public void viewBalance(BigDecimal balance) {
		try {
			String query="select balance from Accounts where accout_no =?";
			preStmt=connection.prepareStatement(query);
			preStmt.setBigDecimal(1, balance);
			preStmt.execute();
			
		}catch(Exception e ) {
			System.out.println("Error is : " + e);
		}
		
	}

}