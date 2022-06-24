package edu.school21.cinema.config;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppConf {

    private String avatarPath;

    public AppConf(String avatarPath) {
        this.avatarPath = avatarPath;
    }
}
