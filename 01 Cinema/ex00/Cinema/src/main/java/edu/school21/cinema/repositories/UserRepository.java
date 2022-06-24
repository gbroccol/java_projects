package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Avatar;
import edu.school21.cinema.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findByLogin(String login) {
        String sql = "SELECT * FROM cinema.user WHERE login = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{login}, new UserRowMapper());
    }

    public void save(User user) {
        Long avatar_id = null;
        if (user.getAvatar() != null) {
            avatar_id = user.getAvatar().getImageId();
        }

        jdbcTemplate.update("INSERT INTO cinema.user " +
                "(login, password, first_name, last_name, phone_number, email, avatar_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?) on conflict (login) do update " +
                "SET avatar_id = EXCLUDED.avatar_id;", user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(), avatar_id);
    }

    public void updateAvatar(User user) {

        Avatar avatar = user.getAvatar();
        final String INSERT_AVATAR = "insert into  cinema.images (user_id, file_name, file_original_name, size, mime) values (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(INSERT_AVATAR, new String[]{"image_id"});
                        ps.setLong(1, user.getUserId());
                        ps.setString(2, avatar.getFileName());
                        ps.setString(3, avatar.getFileOriginalName());
                        ps.setString(4, avatar.getSize());
                        ps.setString(5, avatar.getMime());
                        return ps;
                    }
                }, keyHolder);
        avatar.setImageId((Long) keyHolder.getKey());
        this.save(user);
    }
}
