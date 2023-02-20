package me.jamespurvis.version6restapi.controllers;


import jakarta.websocket.server.PathParam;
import me.jamespurvis.version6restapi.dto.AvatarDto;
import me.jamespurvis.version6restapi.models.Avatar;
import me.jamespurvis.version6restapi.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/avatar/new/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AvatarDto> createAvatar(@RequestBody AvatarDto avatarDto) {
        return new ResponseEntity<>(avatarService.createAvatar(avatarDto), HttpStatus.CREATED);
    }
}
