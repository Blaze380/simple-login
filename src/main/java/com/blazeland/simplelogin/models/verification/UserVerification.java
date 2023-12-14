package com.blazeland.simplelogin.models.verification;

import org.springframework.stereotype.Component;

import com.blazeland.simplelogin.models.User;
import com.blazeland.simplelogin.repository.UserRepository;

@Component
public class UserVerification {
    UserPostStatus userPostStatus;

    public UserVerification() {
        userPostStatus = new UserPostStatus();
    }

    /**
     * F A C A D E
     * 
     * @param user           user Entity
     * @param userRepository JPA repository to manipulate the database
     * @return userPostStatus object
     */
    public UserPostStatus verifyUser(User user, UserRepository userRepository) {
        isUserNameExists(user);
        isUserBirthDateNotNull(user);
        isUserEmailNotNull(user);
        isUserEmailExists(user, userRepository);
        isUserPasswordNotNull(user);
        isUserPhoneNumberNotNull(user);
        isUserPhoneNumberExists(user, userRepository);
        return userPostStatus;
    }

    /**
     * Verifies if the user name is empty or null
     * 
     * @param user user Entity
     */
    private void isUserNameExists(User user) {
        if (user.getUserName().equals("") || user.getUserName().equals(null)) {
            userPostStatus.setBadName();
        }
    }

    /**
     * Verifies if the BirthDate is empty or null
     * 
     * @param user user Entity
     */
    private void isUserBirthDateNotNull(User user) {
        if (user.getUserBirthDate().equals("") || user.getUserBirthDate().equals(null)) {
            userPostStatus.setBadBirthDate();
        }
    }

    /**
     * Verifies if the user email is empty or null
     * 
     * @param user user Entity
     */
    private void isUserEmailNotNull(User user) {
        if (user.getUserEmail().equals("") || user.getUserEmail().equals(null)) {
            userPostStatus.setBadEmail();
        }
    }

    /**
     * Verifies if the user email, is already saved in the database, to prevent
     * duplicated email
     * 
     * @param user           user Entity
     * @param userRepository DataBase object
     */
    private void isUserEmailExists(User user, UserRepository userRepository) {
        if (userRepository.findByUserEmail(user.getUserEmail()) != null) {
            userPostStatus.setDuplicatedEmail();
        }
    }

    /**
     * Verifies if the user phone number has length of 9 digits and has the
     * mozambique operator's code
     * 
     * @param user user Entity
     */
    private void isUserPhoneNumberNotNull(User user) {
        int operatorCode = Integer.parseInt(user.getUserPhoneNumber().substring(0, 2));
        if ((user.getUserPhoneNumber().length() != 9) && ((operatorCode < 82) && (operatorCode > 87))) {
            userPostStatus.setBadPhoneNumber();
        }
    }

    /**
     * Verifies if the user password is empty or null
     * 
     * @param user user Entity
     */
    private void isUserPasswordNotNull(User user) {
        if (user.getUserPassword().equals("") || user.getUserPassword().equals(null)
                || user.getUserPassword().length() < 8) {
            userPostStatus.setBadPassword();
        }
    }

    /**
     * Verifies if the user phone number, is already saved in the database, to
     * prevent duplicated phone number
     * 
     * @param user           user Entity
     * @param userRepository DataBase object
     */
    private void isUserPhoneNumberExists(User user, UserRepository userRepository) {
        if (userRepository.findByUserPhoneNumber(user.getUserPhoneNumber()) != null) {
            userPostStatus.setDuplicatedPhoneNumber();
        }
    }

}