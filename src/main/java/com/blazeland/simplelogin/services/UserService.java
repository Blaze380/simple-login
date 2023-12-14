package com.blazeland.simplelogin.services;

import java.util.List;

import com.blazeland.simplelogin.models.User;
import com.blazeland.simplelogin.models.verification.UserGetStatus;
import com.blazeland.simplelogin.models.verification.UserPostStatus;

public interface UserService {
    UserPostStatus createUser(User user);

    UserPostStatus updateUser(User user);

    UserGetStatus deleteUser(String userEmail, String userPassword);

    UserGetStatus getUser(String userEmail, String userPassword);

    List<User> getAllUsers();
}
