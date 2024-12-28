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
	public void updateBalance(int accountId, BigDecimal amount) {
		String query = "UPDATE Accounts SET balance = ? WHERE account_id = ?";
		try {
			preStmt = connection.prepareStatement(query);
			preStmt.setBigDecimal(1, amount);
			preStmt.setInt(2, accountId);
			preStmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Override
	public Account getAccountById(int accountId) {
		String query = "SELECT * FROM Accounts WHERE account_id = ?";
		try {
			preStmt = connection.prepareStatement(query);
			preStmt = connection.prepareStatement(query);
			preStmt.setInt(1, accountId);
			resultSet = preStmt.executeQuery();
			if (resultSet.next()) {
				return extractAccountFromResultSet(resultSet); //
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Account extractAccountFromResultSet(ResultSet resultSet) throws SQLException {
		Account account = new Account();
		account.setAccountId(resultSet.getInt("account_id"));
		account.setRegId(resultSet.getInt("reg_id"));
		account.setAccountNumber(resultSet.getString("account_number"));
		account.setAccountType(resultSet.getString("account_type"));
		account.setBalance(resultSet.getBigDecimal("balance"));
//		account.setCreatedAt(resultSet.getTimestamp("created_at"));
		return account;
	}

}
