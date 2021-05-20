package com.promineo.week12.Services;

import com.promineo.week12.Models.User;
import com.promineo.week12.Repository.UserRepository;

import java.util.ArrayList;

public class UserService implements IUserService {
    UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public ArrayList<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public User getUser(int userId) {
        return userRepository.getUser(userId);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}
