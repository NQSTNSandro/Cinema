package com.example.demo.DTO;

import lombok.Data;

@Data
public class ClientDto {
    private int id;
    private boolean type;
    private String email;
    private String phone;
    private Integer inn;
    private String kpp;
    private String title;
    private String address;
    private String ogrnip;
}
