package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "actor")
@Setter
@Getter
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fio;
    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.LAZY, mappedBy = "actors")
    Set<Film> films = new HashSet<>();
}
