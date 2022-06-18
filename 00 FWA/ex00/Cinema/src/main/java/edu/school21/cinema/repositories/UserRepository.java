package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Avatar;
import edu.school21.cinema.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

        Avatar avatar = user.getAvatar();
        final String INSERT_AVATAR = "insert into  cinema.images (user_id, file_name, file_original_name, size, mime) values (?, ?, ?, ?, ?)";
//        final String name = "Rob";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(INSERT_AVATAR, new String[] {"user_id"});
                        ps.setLong(1, user.getUserId());
                        ps.setString(2, avatar.getFileName());
                        ps.setString(3, avatar.getFileOriginalName());
                        ps.setString(4, avatar.getSize());
                        ps.setString(5, avatar.getMime());
                        return ps;
                    }
                },
                keyHolder);




//
//
//
//        jdbcTemplate.update("INSERT INTO cinema.images " +
//                "(user_id, file_name, file_original_name, size, mime) " +
//                "VALUES (?, ?, ?, ?)", user.getUserId(), avatar.getFileName(), avatar.getFileOriginalName(), avatar.getSize(), avatar.getMime());
//
//        Avatar avatar1 = (Avatar)jdbcTemplate.query("SELECT * FROM cinema.images WHERE login = ?",
//                        new Object[]{login},
//                        new BeanPropertyRowMapper<>(User.class))
//                .stream().findAny().orElse(null);
//
//        jdbcTemplate.update("UPDATE cinema.user " +
//                        "SET avatar = ? " +
//                        "WHERE user_id = ?",
//                user.getAvatar(),
//                user.getUserId());
    }

//    public void delete(Long id) {
//        jdbcTemplate.update("DELETE FROM cinema.user WHERE user_id = ? ", id);
//    }
}
