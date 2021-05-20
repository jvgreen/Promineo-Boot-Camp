package com.promineo.week12.Services;

import com.promineo.week12.Models.Account;
import com.promineo.week12.Repository.AccountsRepository;

import java.util.ArrayList;

public class AccountsService implements IAccountsService {
    AccountsRepository accountRepository;

    public AccountsService() {
        accountRepository = new AccountsRepository();
    }

    @Override
    public void createAccount(Account account) {
        accountRepository.createAccount(account);
    }

    @Override
    public ArrayList<Account> getAccounts() {
        return accountRepository.getAccounts();
    }

    @Override
    public Account getAccount(int accountNumber) {
        return accountRepository.getAccount(accountNumber);
    }

    @Override
    public void deleteAccount(Account account) {
        accountRepository.deleteAccount(account);
    }

    public void updateAccount(Account account) {
        accountRepository.updateAccount(account);
    }
}
