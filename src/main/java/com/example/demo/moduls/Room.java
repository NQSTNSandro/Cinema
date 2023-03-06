package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "room")
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private int totalPlaces;
    private String type;
    private String projector;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "rooms")
    private Set<Session> session_s=new HashSet<>();

}
