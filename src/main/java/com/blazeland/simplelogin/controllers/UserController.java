package com.blazeland.simplelogin.controllers;

import org.springframework.web.bind.annotation.CookieValue;
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

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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

    @GetMapping("/setcookie")
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("user", "20");
        cookie.setMaxAge(24 * 120 * 10);
        response.addCookie(cookie);
        return "AAAAAAAAAAAAAAAAAAAAAAAA";
    }

    @GetMapping("/getcookie")
    public String getCookie(@CookieValue(name = "user", defaultValue = "arroz com feijao") String cookieValue) {
        return "valor do cookie: " + cookieValue;
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
