package com.example.demo.moduls;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "film")
@Setter
@Getter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;
    private float licenceCost;
    private LocalDate startDate;
    private int ageRestrictions;
    private float rating;
/*
    @JsonManagedReference
*/
    @ManyToMany(mappedBy = "films")
    private Set<Actor> actors = new HashSet<>();


}
