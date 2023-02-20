package me.jamespurvis.version6restapi.repository;

import me.jamespurvis.version6restapi.dto.AvatarDto;
import me.jamespurvis.version6restapi.models.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Avatar findByid(int id);
    Avatar findByUsername(String username);
}
