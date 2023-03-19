package com.example.demo.moduls;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "genre")
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.LAZY, mappedBy = "genres")
    Set<Film> films = new HashSet<>();
}
