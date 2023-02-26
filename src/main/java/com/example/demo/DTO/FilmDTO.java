package com.example.demo.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmDTO {
    private  String title;
    private int duration;
    private float licenceCost;
    private LocalDate startDate;
    private int ageRestrictions;
    private float rating;
}
