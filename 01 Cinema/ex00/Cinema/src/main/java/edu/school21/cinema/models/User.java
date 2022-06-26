package edu.school21.cinema.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @Column(name = "userId", nullable = false)
    private Long userId;

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
