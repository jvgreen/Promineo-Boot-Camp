package com.promineo.week12.Services;

import com.promineo.week12.Models.Account;
import com.promineo.week12.Models.BankViewModel;
import com.promineo.week12.Models.Loan;
import com.promineo.week12.Models.User;

import java.util.ArrayList;

public class BankService implements IBankService {
    private BankViewModel viewModel;
    private UserService userService;
    private AccountsService accountsService;
    private LoanService loanService;

    public BankService (BankViewModel model) {
        viewModel = model;
        userService = new UserService();
        accountsService = new AccountsService();
        loanService = new LoanService();
    }

    @Override
    public void StartBankService() {
        User user;
        Account account;
        Loan loan;

        switch (viewModel.MainMenuChoice) {
            case USER:
                switch (viewModel.CrudChoice) {
                    case CREATE:
                        userService.createUser(new User(viewModel.UserName, viewModel.Password));
                        System.out.println("User created");
                        break;
                    case READ:
                        System.out.println("All Users");
                        ArrayList<User> users = userService.getUsers();
                        for (User s : users) {
                            System.out.println("User Id: " + s.getUserId());
                            System.out.println("UserName: " + s.getUserName());
                            System.out.println("Password: " + s.getPassword());
                        }
                        break;
                    case UPDATE:
                        user = userService.getUser(viewModel.UserId);
                        if(user != null) {
                            user.setUserName(viewModel.UserName);
                            user.setPassword(viewModel.Password);
                            userService.updateUser(user);
                            System.out.println("User updated");
                        } else {
                            System.out.println("User does not exist");
                        }
                        break;
                    case DELETE:
                        user = userService.getUser(viewModel.UserId);
                        if (user != null){
                            userService.deleteUser(user);
                            System.out.println("User was deleted");
                        } else {
                            System.out.println("User does not exist");
                        }
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                break;
            case ACCOUNT:
                switch (viewModel.CrudChoice) {
                    case CREATE:
                        accountsService.createAccount(new Account(viewModel.AccountNumber, viewModel.AccountAmount, viewModel.UserId));
                        System.out.println("Account created");
                        break;
                    case READ:
                        System.out.println("All Accounts");
                        ArrayList<Account> accounts = accountsService.getAccounts();
                        for (Account s : accounts) {
                            System.out.println("Account Id: " + s.getAccountNumber());
                            System.out.println("AccountAmount: " + s.getAccountAmount());
                            System.out.println("UserName: " + s.getUserId());
                        }
                        break;
                    case UPDATE:
                        account = accountsService.getAccount(viewModel.AccountNumber);
                        if (account != null) {
                            account.setAccountNumber(viewModel.AccountNumber);
                            account.setAccountAmount(viewModel.AccountAmount);
                            account.setUserId(viewModel.UserId);
                            accountsService.updateAccount(account);
                            System.out.println("Account updated");
                        } else {
                            System.out.println("Account does not exist");
                        }
                        break;
                    case DELETE:
                        account = accountsService.getAccount(viewModel.AccountNumber);
                        if (account != null) {
                            accountsService.deleteAccount(account);
                            System.out.println("Account was deleted");
                        } else {
                            System.out.println("Account does not exist");
                        }
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                break;
            case LOAN:
                    switch (viewModel.CrudChoice) {
                        case CREATE:
                            loanService.createLoan(new Loan(viewModel.LoanAmount, viewModel.UserId));
                            System.out.println("Loan created");
                            break;
                        case READ:
                            System.out.println("All Loans");
                            ArrayList<Loan> loans = loanService.getLoans();
                            for (Loan s : loans) {
                                System.out.println("Loan Id: " + s.getLoanId());
                                System.out.println("LoanAmount: " + s.getLoanAmount());
                                System.out.println("UserName: " + s.getUserId());
                            }
                            break;
                        case UPDATE:
                            loan = loanService.getLoan(viewModel.LoanId);
                            if (loan != null) {
                                loan.setLoanId(viewModel.LoanId);
                                loan.setLoanAmount(viewModel.LoanAmount);
                                loan.setUserId(viewModel.UserId);
                                loanService.updateLoan(loan);
                                System.out.println("Loan updated");
                            } else {
                                System.out.println("Loan does not exist");
                            }
                            break;
                        case DELETE:
                            loan = loanService.getLoan(viewModel.LoanId);
                            if (loan != null) {
                                loanService.deleteLoan(loan);
                                System.out.println("Loan was deleted");
                            } else {
                                System.out.println("Loan does not exist");
                            }
                            break;
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                break;
            default:
                System.out.println("Invalid Main Menu Choice");
                break;
        }
    }
}
