package com.example.demo.services;

import com.example.demo.DTO.FilmDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Set;

@SpringBootTest
@ActiveProfiles("test")
public class FilmServiceTest {

    @Autowired
    private FilmService filmService;
    @Test
    public void saveTest(){
        FilmDto dto = new FilmDto();
        dto.setAgeRestrictions(16);
        dto.setDuration(120);
        dto.setLicenceCost(100.f);
        dto.setRating(9.9f);
        dto.setStartDate(LocalDate.now());
        dto.setTitle("Test");
        dto.setActors(Set.of());
        dto.setCompanies(Set.of());
        dto.setDirectors(Set.of());
        dto.setCountries(Set.of());
        dto.setGenres(Set.of());
        int id = filmService.save(dto);
        Assertions.assertEquals(1, filmService.read().size());
    }
}
