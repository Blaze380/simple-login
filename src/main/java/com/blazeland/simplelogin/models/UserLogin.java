package com.blazeland.simplelogin.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLogin {
    private String userEmail;
    private String userPassword;
}
