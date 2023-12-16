package com.blazeland.simplelogin.services.implementation;

import java.util.List;
import org.springframework.stereotype.Service;
import com.blazeland.simplelogin.models.User;
import com.blazeland.simplelogin.models.verification.UserGetStatus;
import com.blazeland.simplelogin.models.verification.UserPostStatus;
import com.blazeland.simplelogin.models.verification.UserVerification;
import com.blazeland.simplelogin.repository.UserRepository;
import com.blazeland.simplelogin.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserPostStatus userPostStatus;
    UserGetStatus userGetStatus;

    @Override
    public UserPostStatus createUser(User user) {
        userPostStatus = new UserVerification().verifyUser(user, userRepository);
        userPostStatus.setMethod("POST");
        if (userPostStatus.isSuccess()) {
            userRepository.save(user);
        }
        return userPostStatus;
    }

    @Override
    public UserPostStatus updateUser(User user) {
        userPostStatus = new UserVerification().verifyUser(user, userRepository);
        userPostStatus.setMethod("PUT");
        if (userPostStatus.isSuccess()) {
            userRepository.save(user);
        }
        return userPostStatus;
    }

    @Override
    public UserGetStatus deleteUser(String userEmail, String userPassword) {
        var userId = userRepository.findUserByEmailAndPassword(userEmail, userPassword).getUserId();
        userGetStatus.setMethod("DELETE");
        userGetStatus.setUser(null);
        if (userId.equals(null)) {
            userGetStatus.setSuccess(false);
            userGetStatus.setDeleted(true);

        } else {
            userRepository.deleteById(userId);
            userGetStatus.setSuccess(true);
            userGetStatus.setDeleted(false);
        }
        return userGetStatus;
    }

    @Override
    public UserGetStatus getUser(String userEmail, String userPassword) {
        var user = userRepository.findUserByEmailAndPassword(userEmail, userPassword);
        userGetStatus.setMethod("GET");
        userGetStatus.setUser(null);
        if (user == null) {
            userGetStatus.setSuccess(false);
            userGetStatus.setGet(false);
        } else {
            userGetStatus.setUser(user);
            userGetStatus.setSuccess(true);
            userGetStatus.setGet(true);
        }
        return userGetStatus;

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

}
