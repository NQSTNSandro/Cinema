package com.example.demo.services;

import com.example.demo.DTO.AdTypeDto;
import com.example.demo.DTO.AdvertisingDto;
import com.example.demo.DTO.ClientDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
public class AdvertisingTest {
    @Autowired
    private AdvertisingService advertisingService;
    @Autowired
    private ClientService clientService;
    @Transactional
    @Test
    public void SaveAndReadTest(){
        AdTypeDto adTypeDto=new AdTypeDto();
        adTypeDto.setId(0);
        adTypeDto.setType("test");
        ClientDto clientDto=new ClientDto();
        clientDto.setOgrnip("324");
        clientDto.setEmail("email");
        clientDto.setKpp("av");
        clientDto.setAddress("Agav");
        clientDto.setInn(14);
        clientDto.setTitle("title");
        clientDto.setType(true);
        clientDto.setPhone("891525");
        AdvertisingDto advertisingDto=new AdvertisingDto();
        advertisingDto.setDuration(123);
        advertisingDto.setClient(clientDto);
        advertisingDto.setAdType(adTypeDto);
        int id= advertisingService.save(advertisingDto);
        Assertions.assertEquals(1,id);
        Assertions.assertEquals(1,advertisingService.read().size());
    }
}
