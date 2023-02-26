package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Entity(name = "film")
@Setter
public class Film {
    @Id
    private int id;
    private  String title;
    private int duration;
    private float licenceCost;
    private LocalDate startDate;
    private int ageRestrictions;
    private float rating;
}
