package com.example.demo.services;

import com.example.demo.DTO.FilmDto;
import com.example.demo.DTO.RoomDto;
import com.example.demo.DTO.SessionDto;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.Set;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SessionServiceTest {
    @Autowired
    private SessionService sessionService;

    @Autowired
    private RoomService roomService;
    @Transactional
    @Test
    public void saveTest(){
        SessionDto dto=new SessionDto();
        RoomDto roomDto=new RoomDto();
        roomDto.setProjector("av");
        roomDto.setType("qfgs");
        roomDto.setNumber(1);
        FilmDto filmDto=new FilmDto();
        filmDto.setAgeRestrictions(16);
        filmDto.setDuration(120);
        filmDto.setLicenceCost(100.f);
        filmDto.setRating(9.9f);
        filmDto.setStartDate(LocalDate.now());
        filmDto.setTitle("Test");
        filmDto.setActors(Set.of());
        filmDto.setCompanies(Set.of());
        filmDto.setDirectors(Set.of());
        filmDto.setCountries(Set.of());
        filmDto.setGenres(Set.of());
        dto.setDate(LocalDate.now());
        dto.setCost(15.f);
        dto.setRoom(roomDto);
        dto.setFilm(filmDto);
        int id=sessionService.save(dto);
        Assertions.assertEquals(1,sessionService.read().size());
    }
}