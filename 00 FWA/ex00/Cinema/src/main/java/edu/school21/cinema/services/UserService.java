package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.NotSavedSubEntityException;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

public class UserService {

    private BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
    }

    public void save(User user) {
        if (user.getPassword() == null || user.getPassword().equals("") ||
                user.getLogin() == null || user.getLogin().equals("")) {
            new NotSavedSubEntityException();
        }
        Optional<User> optionalUser = findByLogin(user.getLogin());
        if (optionalUser.isPresent()) {
            new NotSavedSubEntityException();
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);
    }

    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public void update(User user) {
//        userRepository.updateAvatar(user);
//    }

    public void updateAvatar(User user) {
        userRepository.updateAvatar(user);
    }
//
//    public void delete(Long id) {
//        userRepository.delete(id);
//    }
}
