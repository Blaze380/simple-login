package com.blazeland.simplelogin.models.verification;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class UserPostStatus {
    private boolean isBadName;
    private boolean isBadBirthDate;
    private boolean isBadEmail;
    private boolean isBadPassword;
    private boolean isBadPhoneNumber;
    private boolean isDuplicatedEmail;
    private boolean isDuplicatedPhoneNumber;
    private boolean isSuccess;
    private String method;

    public UserPostStatus() {
        method = "NOT DEFINED";
        isSuccess = true;
    }

    public void setBadName() {
        isBadName = true;
        setSuccess(false);
    }

    public void setBadBirthDate() {
        isBadBirthDate = true;
        setSuccess(false);
    }

    public void setBadEmail() {
        isBadEmail = true;
        setSuccess(false);
    }

    public void setBadPassword() {
        isBadPassword = true;
        setSuccess(false);
    }

    public void setBadPhoneNumber() {
        isBadPhoneNumber = true;
        setSuccess(false);
    }

    public void setDuplicatedEmail() {
        isDuplicatedEmail = true;
        setSuccess(false);
    }

    public void setDuplicatedPhoneNumber() {
        isDuplicatedPhoneNumber = true;
        setSuccess(false);
    }

}
