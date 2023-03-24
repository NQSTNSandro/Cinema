package com.example.demo.services;

import com.example.demo.DTO.BookingDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BookingTest{
    @Autowired
    private BookingService bookingService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RowService rowService;

    @Test
    public void saveAndReadTest(){
        BookingDto bookingDto=new BookingDto();
        bookingDto.setType(true);
        bookingDto.setPlace(1);
        bookingDto.setPrice(15F);
        bookingDto.setSession(sessionService.read().get(0));
        bookingDto.setRow(rowService.read().get(0));
        int id=bookingService.save(bookingDto);
        Assertions.assertEquals(1,id);
        Assertions.assertEquals(1,bookingService.read().size());
    }
}
