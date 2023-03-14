package com.example.demo.DTO;


import lombok.Data;

@Data
public class RowDto {
    private int id;
    private int number;
    private int places;
    private float ticketCostMp;
    private RoomDto room;
}
