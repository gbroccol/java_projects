package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.AvatarRepository;
import edu.school21.cinema.repositories.NotSavedSubEntityException;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService {

    private BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private AvatarRepository avatarRepository;

    public UserService(UserRepository userRepository, AvatarRepository avatarRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
        this.avatarRepository= avatarRepository;
    }

    public void save(User user) {
        if (user.getPassword() == null || user.getPassword().equals("") ||
                user.getLogin() == null || user.getLogin().equals("")) {
            new NotSavedSubEntityException();
        }
        User userObj = findByLogin(user.getLogin());
        if (userObj == null) {
            new NotSavedSubEntityException();
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);
    }

    public User findByLogin(String login) {
        User user = userRepository.findByLogin(login);
        user.setAvatar(avatarRepository.findByImageId(user.getAvatar().getImageId()));
        return user;
    }

    public void updateAvatar(User user) {
        userRepository.updateAvatar(user);
    }
}
