package com.promineo.week12.Repository;

import com.promineo.week12.Models.User;

import java.util.ArrayList;

public interface IUserRepository {
    ArrayList<User> getUsers();
    User getUser(int userId);
    void createUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
