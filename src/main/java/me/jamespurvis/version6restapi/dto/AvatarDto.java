package me.jamespurvis.version6restapi.dto;

import lombok.*;
import org.springframework.context.annotation.Bean;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AvatarDto {
    private String username;
    private String customData;
    private String persistentMessage;
    private int credits;
    private int tickets;

    private String figure;

}
