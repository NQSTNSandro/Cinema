package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "advertising")
@Getter
@Setter
public class Advertising {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int duration;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ad_Type")
    private AdType adType;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "advertisings")
    private Set<Session> sessions=new HashSet<>();
}
