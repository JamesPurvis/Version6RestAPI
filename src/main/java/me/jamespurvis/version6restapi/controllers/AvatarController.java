package me.jamespurvis.version6restapi.controllers;


import jakarta.websocket.server.PathParam;
import me.jamespurvis.version6restapi.dto.AvatarDto;
import me.jamespurvis.version6restapi.models.Avatar;
import me.jamespurvis.version6restapi.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;
    @GetMapping("/avatar/id/{id}")
    public ResponseEntity<AvatarDto> avatarDetailsByid(@PathVariable int id) {
        return ResponseEntity.ok(avatarService.findByid(id));
    }

    @GetMapping("/avatar/name/{name}")
    public ResponseEntity<AvatarDto> avatarDetailsByusername(@PathVariable String name) {
        return ResponseEntity.ok(avatarService.findByusername(name));
    }
}
