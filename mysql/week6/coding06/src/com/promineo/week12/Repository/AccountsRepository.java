package com.promineo.week12.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.promineo.week12.Models.Account;


public class AccountsRepository extends MySqlConnection implements IAccountsRepository {
    private Connection connection;

    public AccountsRepository() {
        connection = super.getConnection("bank");
    }

    @Override
    public void createAccount(Account account) {
        try {
            CallableStatement st = connection.prepareCall("{call createAccount(?,?,?)}");
            st.setInt(1, account.getAccountNumber());
            st.setDouble(2, account.getAccountAmount());
            st.setInt(3, account.getUserId());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = new ArrayList<Account>();
        try
        {
            CallableStatement st = connection.prepareCall("{call getAccounts()}");
            boolean hasResult = st.execute();
            if(hasResult)
            {
                ResultSet rs = st.getResultSet();

                while(rs.next())
                {
                    accounts.add(new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3)));
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            return accounts;
        }

        return accounts;
    }

    @Override
    public Account getAccount(int accountNumber) {
        try
        {
            CallableStatement st = connection.prepareCall("{call getAccountById(?)}");
            st.setInt(1, accountNumber);

            boolean hasResult = st.execute();
            if(hasResult)
            {
                ResultSet rs = st.getResultSet();

                while(rs.next())
                {
                    return new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public void deleteAccount(Account account) {
        try {
            CallableStatement st = connection.prepareCall("{call deleteAccount(?)}");
            st.setInt(1, account.getAccountNumber());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            CallableStatement st = connection.prepareCall("{call updateAccount(?,?,?)}");
            st.setInt(1, account.getAccountNumber());
            st.setDouble(2, account.getAccountAmount());
            st.setInt(3, account.getUserId());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
