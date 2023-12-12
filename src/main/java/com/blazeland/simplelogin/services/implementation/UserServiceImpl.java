package com.blazeland.simplelogin.services.implementation;

import java.util.List;
import org.springframework.stereotype.Service;
import com.blazeland.simplelogin.models.User;
import com.blazeland.simplelogin.repository.UserRepository;
import com.blazeland.simplelogin.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public boolean createUser(User user) {
        // TODO miss many login
        if (new UserVerification().verifyUser(user)) {
            userRepository.save(user);
            return true;
        }

        return false;
    }

    @Override
    public boolean updateUser(User user) {
        if (new UserVerification().verifyUser(user)) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(String userEmail, String userPassword) {
        var userId = userRepository.findByUserEmailAndUserPassword(userEmail, userPassword).getUserId();
        userRepository.deleteById(userId);
        return true;
    }

    @Override
    public User getUser(String userEmail, String userPassword) {
        return userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();

    }
}
