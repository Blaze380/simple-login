package com.blazeland.simplelogin.models.verification;

import org.springframework.stereotype.Component;

import com.blazeland.simplelogin.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class UserGetStatus {
    private boolean isSuccess;
    private User user;
    private String method;
    private boolean isDeleted;
    private boolean isGet;

    public UserGetStatus() {
        method = "NOT DEFINED";
        isSuccess = true;
    }
}
