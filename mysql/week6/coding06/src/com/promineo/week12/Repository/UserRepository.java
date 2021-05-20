package com.promineo.week12.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.promineo.week12.Models.User;


public class UserRepository extends MySqlConnection implements IUserRepository {
    private Connection connection;

    public UserRepository() {
        connection = super.getConnection("bank");
    }

    @Override
    public void createUser(User user) {
        try {
            CallableStatement st = connection.prepareCall("{call createUser(?,?)}");
            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try
        {
            CallableStatement st = connection.prepareCall("{call getUsers()}");
            boolean hasResult = st.execute();
            if(hasResult)
            {
                ResultSet rs = st.getResultSet();

                while(rs.next())
                {
                    users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            return users;
        }

        return users;
    }

    @Override
    public User getUser(int userId) {
        try
        {
            CallableStatement st = connection.prepareCall("{call getUserById(?)}");
            st.setInt(1, userId);

            boolean hasResult = st.execute();
            if(hasResult)
            {
                ResultSet rs = st.getResultSet();

                while(rs.next())
                {
                    return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
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
    public void deleteUser(User user) {
        try {
            CallableStatement st = connection.prepareCall("{call deleteUser(?)}");
            st.setInt(1, user.getUserId());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            CallableStatement st = connection.prepareCall("{call updateUser(?,?,?)}");
            st.setInt(1, user.getUserId());
            st.setString(2, user.getUserName());
            st.setString(3, user.getPassword());
            st.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
