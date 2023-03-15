package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "row")
@Getter
@Setter
public class Row {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private int places;
    private float ticketCostMp;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "row")
    private Set<Booking> bookings=new HashSet<>();
}
