package com.blazeland.simplelogin.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String userBirthDate;
    private String userPhoneNumber;
    private String userEmail;
    private String userPassword;

    public User(String userName, String userBirthDate, String userPhoneNumber, String userEmail, String userPassword) {
        this.userName = userName;
        this.userBirthDate = userBirthDate;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
