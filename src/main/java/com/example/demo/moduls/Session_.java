package com.example.demo.moduls;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity(name = "session")
@Getter
@Setter
public class Session_ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int filmId;
    private LocalDate date;
    private float cost;
    private int roomId;
}
