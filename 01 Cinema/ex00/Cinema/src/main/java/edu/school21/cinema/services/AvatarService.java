package edu.school21.cinema.services;

import edu.school21.cinema.models.Avatar;
import edu.school21.cinema.repositories.AvatarRepository;
import lombok.Getter;
import lombok.Setter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Getter
@Setter
public class AvatarService {

    private final Path appAvatarsPath;
    private final AvatarRepository avatarRepository;

    public AvatarService(String appAvatarsPath, AvatarRepository avatarRepository) {
        Path path = Paths.get(appAvatarsPath);
        this.appAvatarsPath = path;
        this.avatarRepository = avatarRepository;
    }

    public List <Avatar> findAllByUserId(Long userId) {
        return avatarRepository.findAllByUserId(userId);
    }
}