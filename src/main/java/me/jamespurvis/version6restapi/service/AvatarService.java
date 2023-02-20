package me.jamespurvis.version6restapi.service;

import lombok.AccessLevel;
import lombok.Setter;
import me.jamespurvis.version6restapi.dto.AvatarDto;
import me.jamespurvis.version6restapi.dto.AvatarResponse;
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

    public AvatarDto createAvatar(AvatarDto avatarDto) {

        Avatar avatar = new Avatar();
        avatar.setUsername(avatarDto.getUsername());
        avatar.setMission(avatarDto.getCustomData());
        avatar.setPersistent_message(avatarDto.getPersistentMessage());
        avatar.setCredits(avatarDto.getCredits());
        avatar.setTickets(avatarDto.getTickets());
        avatar.setFigure(avatarDto.getFigure());

        Avatar newAvatar = avatarRepository.save(avatar);

        AvatarDto avatarResponse = new AvatarDto();
        avatarResponse.setUsername(newAvatar.getUsername());
        avatarResponse.setCustomData(newAvatar.getMission());
        avatarResponse.setPersistentMessage(newAvatar.getPersistent_message());
        avatarResponse.setCredits(newAvatar.getCredits());
        avatarResponse.setTickets(newAvatar.getTickets());
        avatarResponse.setFigure(newAvatar.getFigure());

        return avatarResponse;

    }
}
