package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Avatar;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.List;

public class AvatarRepository {

    JdbcTemplate jdbcTemplate;

    public AvatarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Avatar findByImageId(Long image_id) {

        String sql = "SELECT * FROM cinema.images WHERE image_id = ?";
        Avatar avatar = null;

        try {
            avatar = jdbcTemplate.queryForObject(sql, new Object[]{image_id}, new AvatarRowMapper());
        } catch (EmptyResultDataAccessException ex) {

        }
        return avatar;
    }

    public List<Avatar> findAllByUserId(Long userId) {
        String query = "select * from cinema.images where user_id = ?";
        List<Avatar> avatars = jdbcTemplate.query(query, (ResultSet rs, int rowNum) -> {
            Long imageId = rs.getLong("image_id");
            String fileName = rs.getString("file_name");
            String fileOriginalName = rs.getString("file_original_name");
            String size = rs.getString("size");
            String mime = rs.getString("mime");
            return new Avatar(imageId, userId, fileName, fileOriginalName, size, mime);
        }, userId);
        return avatars;
    }
}
