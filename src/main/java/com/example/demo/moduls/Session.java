package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "session")
@Getter
@Setter
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private Film film;
    private LocalDate date;
    private float cost;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "session_ad",
            joinColumns = { @JoinColumn(name = "session_id") },
            inverseJoinColumns = { @JoinColumn(name = "advertising_id") }
    )
    private Set<Advertising> advertisings =new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "session")
    private Set<Booking> bookings=new HashSet<>();
}
