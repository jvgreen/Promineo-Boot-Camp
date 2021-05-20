package com.promineo.week12.Services;

import com.promineo.week12.Models.User;

import java.util.ArrayList;

public interface IUserService {
    ArrayList<User> getUsers();
    User getUser(int userId);
    void createUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
