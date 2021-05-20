package com.promineo.week12.Models;

public class Loan {
    private int loanId;
    private double loanAmount;
    private int userId;

    public Loan(int loanId, double loanAmount, int userId) {
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.userId = userId;
    }

    public Loan(double loanAmount, int userId) {
        this.loanAmount = loanAmount;
        this.userId = userId;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
