package com.promineo.week12.Services;

import com.promineo.week12.Models.Loan;
import com.promineo.week12.Repository.LoanRepository;

import java.util.ArrayList;

public class LoanService implements ILoanService {
    LoanRepository loanRepository;

    public LoanService() {
        loanRepository = new LoanRepository();
    }

    @Override
    public void createLoan(Loan loan) {
        loanRepository.createLoan(loan);
    }

    @Override
    public ArrayList<Loan> getLoans() {
        return loanRepository.getLoans();
    }

    @Override
    public Loan getLoan(int loanId) {
        return loanRepository.getLoan(loanId);
    }

    @Override
    public void deleteLoan(Loan loan) {
        loanRepository.deleteLoan(loan);
    }

    public void updateLoan(Loan loan) {
        loanRepository.updateLoan(loan);
    }
}
