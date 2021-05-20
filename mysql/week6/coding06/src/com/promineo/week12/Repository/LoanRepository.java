package com.promineo.week12.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.promineo.week12.Models.Loan;


public class LoanRepository extends MySqlConnection implements ILoanRepository {
    private Connection connection;

    public LoanRepository() {
        connection = super.getConnection("bank");
    }

    @Override
    public void createLoan(Loan loan) {
        try {
            CallableStatement st = connection.prepareCall("{call createLoan(?,?)}");
            st.setDouble(1, loan.getLoanAmount());
            st.setInt(2, loan.getUserId());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Loan> getLoans() {
        ArrayList<Loan> loans = new ArrayList<Loan>();
        try
        {
            CallableStatement st = connection.prepareCall("{call getLoans()}");
            boolean hasResult = st.execute();
            if(hasResult)
            {
                ResultSet rs = st.getResultSet();

                while(rs.next())
                {
                    loans.add(new Loan(rs.getInt(1), rs.getDouble(2), rs.getInt(3)));
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            return loans;
        }

        return loans;
    }

    @Override
    public Loan getLoan(int loanId) {
        try
        {
            CallableStatement st = connection.prepareCall("{call getLoanById(?)}");
            st.setInt(1, loanId);

            boolean hasResult = st.execute();
            if(hasResult)
            {
                ResultSet rs = st.getResultSet();

                while(rs.next())
                {
                    return new Loan(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
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
    public void deleteLoan(Loan loan) {
        try {
            CallableStatement st = connection.prepareCall("{call deleteLoan(?)}");
            st.setInt(1, loan.getLoanId());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateLoan(Loan loan) {
        try {
            CallableStatement st = connection.prepareCall("{call updateLoan(?,?,?)}");
            st.setInt(1, loan.getLoanId());
            st.setInt(1, loan.getLoanId());
            st.setDouble(2, loan.getLoanAmount());
            st.setInt(3, loan.getUserId());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
