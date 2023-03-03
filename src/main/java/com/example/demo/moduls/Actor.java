package com.example.demo.moduls;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

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
/*
    @JsonBackReference
*/
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "actor_linker",
            joinColumns = { @JoinColumn(name = "actor_id") },
            inverseJoinColumns = { @JoinColumn(name = "film_id") }
    )
    Set<Film> films = new HashSet<>();
}
