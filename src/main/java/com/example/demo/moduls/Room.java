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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Set<Session> sessions = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Set<Row> rows = new HashSet<>();

}
