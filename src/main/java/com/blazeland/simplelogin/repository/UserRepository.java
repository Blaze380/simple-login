package com.blazeland.simplelogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazeland.simplelogin.models.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);

    List<User> findByUserName(String userName);

    User findByUserEmailAndUserPassword(String userEmail, String userPassword);

    List<User> findByUserPhoneNumber(String userPhoneNumber);

    List<User> findByUserEmail(String userEmail);
}
