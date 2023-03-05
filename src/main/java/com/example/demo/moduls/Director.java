package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "director")
@Getter
@Setter
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fio;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "director_linker",
            joinColumns = { @JoinColumn(name = "director_id") },
            inverseJoinColumns = { @JoinColumn(name = "film_id") }
    )
    Set<Film> films = new HashSet<>();
}
