package com.example.demo.DTO;

import lombok.Data;

@Data
public class AdvertisingDto {
    private int id;
    private int duration;
    private AdTypeDto adType;
    private ClientDto client;
}
