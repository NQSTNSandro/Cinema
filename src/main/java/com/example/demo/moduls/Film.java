package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Entity(name = "film")
@Setter
@Getter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String title;
    private int duration;
    private float licenceCost;
    private LocalDate startDate;
    private int ageRestrictions;
    private float rating;
}
