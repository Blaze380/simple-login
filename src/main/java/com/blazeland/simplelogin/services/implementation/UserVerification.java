package com.blazeland.simplelogin.services.implementation;

import com.blazeland.simplelogin.models.User;

public class UserVerification {

    public boolean verifyUser(User user) {
        if (!isUserBirthDateExists(user) || !isUserEmailExists(user) || !isUserNameExists(user)
                || !isUserPasswordExists(user) || !isUserPhoneNumberExists(user)) {
            return false;
        }
        return true;
    }

    private boolean isUserNameExists(User user) {
        if (user.getUserName().equals("") || user.getUserName().equals(null)) {
            return false;
        }
        return true;
    }

    // FIXME remake the birth date logic
    private boolean isUserBirthDateExists(User user) {
        if (user.getUserBirthDate().equals("") || user.getUserBirthDate().equals(null)) {
            return false;
        }
        return true;
    }

    // TODO it's missing adding more email endings
    private boolean isUserEmailExists(User user) {
        if (!(user.getUserEmail().equals("") || user.getUserEmail().equals(null))) {
            if ((user.getUserEmail().endsWith("@gmail.com")) || (user.getUserEmail().endsWith("@yahoo.com.br"))) {
                return true;
            }
        }

        return false;

    }

    private boolean isUserPhoneNumberExists(User user) {
        if (user.getUserPhoneNumber().length() == 9) {
            int operatorCode = Integer.parseInt(user.getUserPhoneNumber().substring(0, 2));
            if ((operatorCode >= 82) && (operatorCode <= 87)) {
                return true;
            }
        }

        return false;
    }

    private boolean isUserPasswordExists(User user) {
        if (!(user.getUserPassword().equals("") || user.getUserPassword().equals(null))) {
            if (user.getUserPassword().length() >= 8) {
                return true;
            }
        }
        return false;
    }

}