package com.example.demo.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class FilmDTO {
    private int id;
    private  String title;
    private Integer duration;
    private Float licenceCost;
    private LocalDate startDate;
    private Integer ageRestrictions;
    private Float rating;
    private Set<ActorDto> actors;

}
