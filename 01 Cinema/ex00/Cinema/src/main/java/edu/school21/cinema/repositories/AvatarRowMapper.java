package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Avatar;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AvatarRowMapper implements RowMapper<Avatar> {

    @Override
    public Avatar mapRow(ResultSet rs, int rowNum) throws SQLException {

        Avatar avatar = new Avatar();
        avatar.setImageId(rs.getLong("image_id"));
        avatar.setUserId(rs.getLong("user_id"));
        avatar.setFileName(rs.getString("file_name"));
        avatar.setFileOriginalName(rs.getString("file_original_name"));
        avatar.setSize(rs.getString("size"));
        avatar.setMime(rs.getString("mime"));
        return avatar;
    }
}