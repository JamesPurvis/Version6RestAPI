package me.jamespurvis.version6restapi.service;

import lombok.AccessLevel;
import lombok.Setter;
import me.jamespurvis.version6restapi.dto.AvatarDto;
import me.jamespurvis.version6restapi.models.Avatar;
import me.jamespurvis.version6restapi.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;

    public AvatarDto findByid(int id) {
        Avatar instance = avatarRepository.findByid(id);
        return toDto(instance);
    }

    public AvatarDto findByusername(String username) {
        Avatar instance = avatarRepository.findByUsername(username);
        return toDto(instance);

    }

    public Avatar save(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    public AvatarDto toDto(Avatar avatar) {
        AvatarDto dto = new AvatarDto();
        dto.setUsername(avatar.getUsername());
        dto.setCustomData(avatar.getMission());
        dto.setTickets(avatar.getTickets());
        dto.setFigure((avatar.getFigure()));
        dto.setPersistentMessage(avatar.getPersistent_message());
        dto.setCredits(avatar.getCredits());

        return dto;
    }
}
