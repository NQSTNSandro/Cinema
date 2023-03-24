package com.example.demo.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ClientTest {
    @Autowired
    private ClientService clientService;
    @Test
    public void readTest(){
        Assertions.assertEquals(1,clientService.read().size());
    }
}
