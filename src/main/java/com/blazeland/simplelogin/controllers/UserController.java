package com.blazeland.simplelogin.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blazeland.simplelogin.models.User;
import com.blazeland.simplelogin.models.UserLogin;
import com.blazeland.simplelogin.models.verification.UserGetStatus;
import com.blazeland.simplelogin.models.verification.UserPostStatus;
import com.blazeland.simplelogin.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @PostMapping("/post")
    public UserPostStatus createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public UserPostStatus updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/get")
    public UserGetStatus getUser(@RequestParam("userEmail") String userEmail,
            @RequestParam("userPassword") String userPassword) {
        return userService.getUser(userEmail,
                userPassword);

    }

    @DeleteMapping("/delete")
    public UserGetStatus deleteUser(@RequestBody UserLogin userLogin) {
        return userService.deleteUser(userLogin.getUserEmail(), userLogin.getUserPassword());
    }

}
