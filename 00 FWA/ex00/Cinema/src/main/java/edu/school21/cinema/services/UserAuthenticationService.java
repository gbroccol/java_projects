package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.models.UserAuthentication;
import edu.school21.cinema.repositories.UserAuthenticationRepository;

import java.util.List;

public class UserAuthenticationService {

    private UserAuthenticationRepository userAuthenticationRepository;

    public UserAuthenticationService(UserAuthenticationRepository userAuthenticationRepository) {
        this.userAuthenticationRepository = userAuthenticationRepository;
    }

    public void save(User user, String ip) {
        userAuthenticationRepository.save(user, ip);
    }

    public List<UserAuthentication> findAllByUserId(String userId) {
        return userAuthenticationRepository.findAllByUserId(userId);
    }
}
