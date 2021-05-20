package com.promineo.week12.Services;

import com.promineo.week12.Models.Loan;

import java.util.ArrayList;

public interface ILoanService {
    ArrayList<Loan> getLoans();
    Loan getLoan(int loanId);
    void createLoan(Loan loan);
    void deleteLoan(Loan loan);
    void updateLoan(Loan loan);
}
