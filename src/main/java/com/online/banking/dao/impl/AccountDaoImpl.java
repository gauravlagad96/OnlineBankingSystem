package com.online.banking.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.online.banking.dao.AccountDao;
import com.online.banking.dao.DbState;
import com.online.banking.entities.Account;

public class AccountDaoImpl extends DbState implements AccountDao {

	@Override
	public void createAccount(Account account) {
		String query = "INSERT INTO Accounts (reg_id, account_number, account_type, balance) VALUES (?, ?, ?, ?)";
		try (PreparedStatement preStmt = connection.prepareStatement(query)) {
			preStmt.setInt(1, account.getRegId());
			preStmt.setString(2, account.getAccountNumber());
			preStmt.setString(3, account.getAccountType());
			preStmt.setBigDecimal(4, account.getBalance());
			preStmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Error is : " + ex.getMessage());
		}
	}

	@Override
	public BigDecimal viewBalance(String accountNumber) {
		String query = "SELECT balance FROM Accounts WHERE account_number = ?";
		try (PreparedStatement preStmt = connection.prepareStatement(query)) {
			preStmt.setString(1, accountNumber);
			try (ResultSet resultSet = preStmt.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getBigDecimal("balance");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error is: " + e.getMessage());
		}
		return BigDecimal.ZERO;
	}

	@Override
	public void deposit(String accountNumber, BigDecimal amount) {
		String query = "UPDATE Accounts SET balance = balance + ? WHERE account_number = ?";
		try (PreparedStatement preStmt = connection.prepareStatement(query)) {
			preStmt.setBigDecimal(1, amount);
			preStmt.setString(2, accountNumber);
			int rowsAffected = preStmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Amount deposited successfully.");
			} else {
				System.out.println("Account not found for account_no: " + accountNumber);
			}
		} catch (SQLException e) {
			System.out.println("Database error: " + e.getMessage());
		}
	}

	@Override
	public void withdraw(String accountNumber, BigDecimal amount) {
		String fetchBalanceQuery = "SELECT balance FROM Accounts WHERE account_number = ?";
		try (PreparedStatement preStmt = connection.prepareStatement(fetchBalanceQuery)) {
			preStmt.setString(1, accountNumber);
			try (ResultSet resultSet = preStmt.executeQuery()) {
				if (!resultSet.next()) {
					throw new IllegalArgumentException("Account not found for account_number: " + accountNumber);
				}

				BigDecimal currentBalance = resultSet.getBigDecimal("balance");

				if (currentBalance.compareTo(amount) < 0) {
					throw new IllegalArgumentException("Insufficient balance.");
				}

				String updateBalanceQuery = "UPDATE Accounts SET balance = balance - ? WHERE account_number = ?";
				try (PreparedStatement updateStmt = connection.prepareStatement(updateBalanceQuery)) {
					updateStmt.setBigDecimal(1, amount);
					updateStmt.setString(2, accountNumber);
					updateStmt.executeUpdate();
				}

				System.out.println("Withdrawal successful.");
			}
		} catch (SQLException e) {
			System.out.println("Database error: " + e.getMessage());
		}
	}

	@Override
	public void transferMoney(String sourceAccountNumber, String destinationAccountNumber, BigDecimal amount) {
		try {
			connection.setAutoCommit(false); // Start a transaction

			// Fetch source account details
			String fetchSourceAccountQuery = "SELECT account_id, balance FROM Accounts WHERE account_number = ?";
			try (PreparedStatement fetchStmt = connection.prepareStatement(fetchSourceAccountQuery)) {
				fetchStmt.setString(1, sourceAccountNumber);
				try (ResultSet sourceResult = fetchStmt.executeQuery()) {
					if (!sourceResult.next()) {
						throw new IllegalArgumentException("Source account not found.");
					}

					int sourceAccountId = sourceResult.getInt("account_id");
					BigDecimal sourceBalance = sourceResult.getBigDecimal("balance");

					if (sourceBalance.compareTo(amount) < 0) {
						throw new IllegalArgumentException("Insufficient balance in the source account.");
					}

					// Fetch destination account details
					String fetchDestinationAccountQuery = "SELECT account_id FROM Accounts WHERE account_number = ?";
					try (PreparedStatement fetchDestStmt = connection.prepareStatement(fetchDestinationAccountQuery)) {
						fetchDestStmt.setString(1, destinationAccountNumber);
						try (ResultSet destinationResult = fetchDestStmt.executeQuery()) {
							if (!destinationResult.next()) {
								throw new IllegalArgumentException("Destination account not found.");
							}

							int destinationAccountId = destinationResult.getInt("account_id");

							// Update balances
							String deductSourceBalanceQuery = "UPDATE Accounts SET balance = balance - ? WHERE account_number = ?";
							try (PreparedStatement updateStmt = connection.prepareStatement(deductSourceBalanceQuery)) {
								updateStmt.setBigDecimal(1, amount);
								updateStmt.setString(2, sourceAccountNumber);
								updateStmt.executeUpdate();
							}

							String addDestinationBalanceQuery = "UPDATE Accounts SET balance = balance + ? WHERE account_number = ?";
							try (PreparedStatement updateStmt = connection
									.prepareStatement(addDestinationBalanceQuery)) {
								updateStmt.setBigDecimal(1, amount);
								updateStmt.setString(2, destinationAccountNumber);
								updateStmt.executeUpdate();
							}

							// Log transaction
							String logTransactionQuery = "INSERT INTO Transactions (source_account_id, destination_account_id, amount, transaction_type) VALUES (?, ?, ?, ?)";
							try (PreparedStatement logStmt = connection.prepareStatement(logTransactionQuery)) {
								logStmt.setInt(1, sourceAccountId);
								logStmt.setInt(2, destinationAccountId);
								logStmt.setBigDecimal(3, amount);
								logStmt.setString(4, "Transfer");
								logStmt.executeUpdate();
							}

							connection.commit(); // Commit the transaction
							System.out.println("Money transferred successfully.");
						}
					}
				}
			}
		} catch (SQLException e) {
			try {
				connection.rollback(); // Rollback in case of error
			} catch (SQLException rollbackEx) {
				System.out.println("Rollback failed: " + rollbackEx.getMessage());
			}
			System.out.println("Error during transfer: " + e.getMessage());
		}
	}
}
