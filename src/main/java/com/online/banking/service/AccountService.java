package com.online.banking.service;

import java.util.List;

import com.online.banking.entities.Account;

public interface AccountService {
    boolean createAccount(Account account);
    Account getAccountById(int accountId);
    List<Account> getAccountsByUserId(int userId);
    boolean updateAccountBalance(int accountId, double newBalance);
    boolean deleteAccount(int accountId);
}