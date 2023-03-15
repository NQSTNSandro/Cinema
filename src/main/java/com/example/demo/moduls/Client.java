package com.example.demo.moduls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "client")
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean type;
    @Column(name="e-mail")
    private String email;
    private String phone;
    private Integer inn;
    private String kpp;
    private String title;
    private String address;
    private String ogrnip;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Advertising> advertisings=new HashSet<>();

}
