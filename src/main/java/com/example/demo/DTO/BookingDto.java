package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class BookingDto {
    private int id;
    private float price;
    private int place;
    private boolean type;
    private SessionDto session;
    private RowDto row;

}
