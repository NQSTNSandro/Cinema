package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ticket")
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int ticketNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
