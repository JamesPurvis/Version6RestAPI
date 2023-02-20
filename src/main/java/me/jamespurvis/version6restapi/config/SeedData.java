package me.jamespurvis.version6restapi.config;

import me.jamespurvis.version6restapi.models.Avatar;
import me.jamespurvis.version6restapi.repository.AvatarRepository;
import me.jamespurvis.version6restapi.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SeedData implements CommandLineRunner {


    @Autowired
    private AvatarService avatarService;


    @Override
    public void run(String... args) throws Exception {

        Avatar avatar = new Avatar();
        avatar.setId(Long.getLong("1"));
        avatar.setUsername("Admin");
        avatar.setPassword("lol123");
        avatar.setEmail("lol@lol.com");
        avatar.setFigure("12231912912323921");
        avatar.setMission("I am new.");
        avatar.setPersistent_message("I am new.");
        avatar.setCredits(0);
        avatar.setTickets(0);
        avatar.setFilm(0);
        avatar.setPool_figure("/");
        avatar.setSex('M');

        avatarService.save(avatar);

    }
}
