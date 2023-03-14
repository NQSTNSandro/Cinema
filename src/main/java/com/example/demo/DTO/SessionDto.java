package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;


@Data
public class SessionDto {
    private int id;
    private FilmDto film;
    private LocalDate date;
    private float cost;
    private RoomDto room;

}
