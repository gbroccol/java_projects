package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class UserRepository {

    JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO cinema.user " +
                "(login, password, first_name, last_name, phone_number, email)" +
                " VALUES (?, ?, ?, ?, ?, ?)", user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail());
    }

    public Optional<User> findByLogin(String login) {
        User user = (User)jdbcTemplate.query("SELECT * FROM cinema.user WHERE login = ?",
                        new Object[]{login},
                        new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
        if (user == null)
            return Optional.empty();
        return Optional.of(user);
    }

//    public void update(User user) {
//
//        jdbcTemplate.update("INSERT INTO cinema.user " +
//                "(login, password, first_name, last_name, phone_number, email)" +
//                " VALUES (?, ?, ?, ?, ?, ?)", user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail());
//
//
//
//    }

//    public List<User> findAll() {
//        return jdbcTemplate.query("SELECT * FROM cinema.user", new BeanPropertyRowMapper<>(User.class));
//    }

    public void updateAvatar(User user) {
        jdbcTemplate.update("UPDATE cinema.user " +
                        "SET avatar = ? " +
                        "WHERE user_id = ?",
                user.getAvatar(),
                user.getUserId());
    }

//    public void delete(Long id) {
//        jdbcTemplate.update("DELETE FROM cinema.user WHERE user_id = ? ", id);
//    }
}
