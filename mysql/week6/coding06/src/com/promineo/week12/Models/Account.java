package com.promineo.week12.Models;

public class Account {
    private int accountNumber;
    private double accountAmount;
    private int userId;

    public Account (int accountNumber, double accountAmount, int userId) {
        this.accountNumber = accountNumber;
        this.accountAmount = accountAmount;
        this.userId = userId;
    }

    public double getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(double accountAmount) {
        this.accountAmount = accountAmount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
