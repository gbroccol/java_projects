package edu.school21.cinema.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Long        userId;
    private String      login;
    private String      password;
    private String      firstName;
    private String      lastName;
    private String      phoneNumber;
    private String      email;
    private Avatar      avatar;

    public User(String login, String password, String firstName, String lastName, String phoneNumber, String email) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
