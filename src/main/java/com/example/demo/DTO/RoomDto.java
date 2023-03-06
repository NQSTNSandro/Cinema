package com.example.demo.DTO;

import lombok.Data;

@Data
public class RoomDto {
    private int id;
    private int number;
    private int totalPlaces;
    private String type;
    private String projector;
}
