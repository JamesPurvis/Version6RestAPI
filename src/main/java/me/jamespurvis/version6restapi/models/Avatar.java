package me.jamespurvis.version6restapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(name = "avatars")
public class Avatar
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "figure")
    private String figure;

    @Column(name = "mission")
    private String mission;

    @Column(name = "persistent_message")
    private String persistent_message;

    @Column(name = "tickets")
    private int tickets;

    @Column(name = "film")
    private int film;

    @Column(name = "credits")
    private int credits;

    @Column(name = "sex")
    private char sex;

    @Column(name = "pool_figure")
    private String pool_figure;
}
