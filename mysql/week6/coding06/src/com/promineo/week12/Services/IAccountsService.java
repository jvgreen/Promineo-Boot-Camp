package com.promineo.week12.Services;

import com.promineo.week12.Models.Account;

import java.util.ArrayList;

public interface IAccountsService {
    ArrayList<Account> getAccounts();
    Account getAccount(int accountNumber);
    void createAccount(Account account);
    void deleteAccount(Account account);
    void updateAccount(Account account);
}
