package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "ad_type")
@Getter
@Setter
public class AdType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Advertising> advertisings=new HashSet<>();
}
