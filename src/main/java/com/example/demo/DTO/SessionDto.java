package com.example.demo.DTO;

import com.example.demo.moduls.Film;
import com.example.demo.moduls.Room;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class SessionDto {
    private int id;
    private Film film;
    private LocalDate date;
    private float cost;
    private Set<RoomDto> rooms;

}
