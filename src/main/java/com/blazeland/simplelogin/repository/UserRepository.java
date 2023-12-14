package com.blazeland.simplelogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blazeland.simplelogin.models.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);

    List<User> findByUserName(String userName);

    @Query("SELECT u FROM User u WHERE u.userEmail = :userEmail AND u.userPassword = :userPassword")
    User findUserByEmailAndPassword(@Param("userEmail") String userEmail,
            @Param("userPassword") String userPassword);

    User findByUserPhoneNumber(String userPhoneNumber);

    User findByUserEmail(String userEmail);

    @Query("SELECT u FROM User u WHERE u.userPassword = :userPassword")
    User findByUserPassword(@Param("userPassword") String userPassword);
}
