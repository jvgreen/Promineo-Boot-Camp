package com.promineo.week12.Repository;

import com.promineo.week12.Models.Loan;

import java.util.ArrayList;

public interface ILoanRepository {
    ArrayList<Loan> getLoans();
    Loan getLoan(int loanId);
    void createLoan(Loan loan);
    void deleteLoan(Loan loan);
    void updateLoan(Loan loan);
}
