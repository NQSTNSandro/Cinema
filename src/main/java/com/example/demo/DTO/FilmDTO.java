package com.example.demo.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmDTO {
    private int id;
    private  String title;
    private Integer duration;
    private Float licenceCost;
    private LocalDate startDate;
    private Integer ageRestrictions;
    private Float rating;
}
