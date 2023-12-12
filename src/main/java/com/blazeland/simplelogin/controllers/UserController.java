package com.blazeland.simplelogin.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blazeland.simplelogin.models.User;
import com.blazeland.simplelogin.models.UserLogin;
import com.blazeland.simplelogin.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @PostMapping("/post")
    public boolean createUser(@RequestBody User user) {
        boolean isUserCreated = userService.createUser(user);
        return isUserCreated;
    }

    @PutMapping("/update")
    public boolean updateUser(@RequestBody User user) {
        boolean isUserUpdated = userService.updateUser(user);
        return isUserUpdated;
    }

    @GetMapping("/get")
    public User getUser(@RequestBody UserLogin userLogin) {
        return userService.getUser(userLogin.getUserEmail(), userLogin.getUserPassword());
    }

    @DeleteMapping("/delete")
    public boolean deleteUser(@RequestBody UserLogin userLogin) {
        boolean isUserDeleted = userService.deleteUser(userLogin.getUserEmail(), userLogin.getUserPassword());
        return isUserDeleted;
    }

}
