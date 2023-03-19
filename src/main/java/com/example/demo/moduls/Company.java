package com.example.demo.moduls;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "company")
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int foundation;
    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.LAZY, mappedBy = "companies")
    Set<Film> films = new HashSet<>();
}
