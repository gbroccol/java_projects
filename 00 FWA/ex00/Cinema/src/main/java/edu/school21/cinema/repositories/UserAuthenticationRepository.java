package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import edu.school21.cinema.models.UserAuthentication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserAuthenticationRepository {

    JdbcTemplate jdbcTemplate;

    public UserAuthenticationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user, String ip) {
        jdbcTemplate.update("INSERT INTO cinema.user_authentication_history " +
                "(user_id, auth_date, auth_time, auth_ip)" +
                " VALUES (?, TO_CHAR(now(), 'Month dd, yyyy')," +
                "TO_CHAR(now(), 'HH24:MI'),  ?)", user.getUserId(), ip);
    }

//    public List<UserAuthentication> findAllByUserId(String userId) {
//
//        String query = "SELECT * FROM cinema.user_authentication_history where user_id = 1"; // + userId;
//
//        return jdbcTemplate.query(query,
//                new BeanPropertyRowMapper<>(UserAuthentication.class));
//    }

    public List<UserAuthentication> findAllByUserId(String userId) {

        String sql = "SELECT * FROM cinema.user_authentication_history where user_id = " + userId;

//        return jdbcTemplate.query(query,
//                new BeanPropertyRowMapper<>(UserAuthentication.class));


        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new UserAuthentication(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("auth_date"),
                                rs.getString("auth_time"),
                                rs.getString("auth_ip")
                        )
        );
    }
}
