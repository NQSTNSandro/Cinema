package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "booking")
@Setter
@Getter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float price;
    private int place;
    private boolean type;
    @OneToOne(cascade = CascadeType.ALL)
    private Ticket ticket;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_id")
    private Session session;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "row_id")
    private Row row;


}
