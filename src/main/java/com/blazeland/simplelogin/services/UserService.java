package com.blazeland.simplelogin.services;

import java.util.List;

import com.blazeland.simplelogin.models.User;

public interface UserService {
    boolean createUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(String userEmail, String userPassword);

    User getUser(String userEmail, String userPassword);

    List<User> getAllUsers();
}
