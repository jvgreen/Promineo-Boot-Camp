package com.promineo.week12.Repository;

import com.promineo.week12.Models.Account;

import java.util.ArrayList;

public interface IAccountsRepository {
    ArrayList<Account> getAccounts();
    Account getAccount(int accountNumber);
    void createAccount(Account account);
    void deleteAccount(Account account);
    void updateAccount(Account account);
}
