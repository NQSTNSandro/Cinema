package com.example.demo.services;

import com.example.demo.DTO.FilmDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FilmServiceTest {

    @Autowired
    private FilmService filmService;

    @Test
    public void saveTest() {
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

    @Test
    public void deleteTest() {
        FilmDto filmDto = newFilmDto();
        int id = filmService.save(filmDto);
        filmService.remove(id);
        Assertions.assertEquals(0, filmService.read().size());
    }

    @Transactional
    @Test
    public void updateTest() {
        int id1 = filmService.save(newFilmDto());
        int id2 = filmService.save(newFilmDto());
        int id3 = filmService.save(newFilmDto());
        String title = "Update";
        FilmDto filmDto = newFilmDto();
        filmDto.setId(id1);
        filmDto.setTitle(title);
        filmDto.setStartDate(LocalDate.now());
        filmDto.setAgeRestrictions(5);
        filmDto.setDuration(1000);
        filmDto.setLicenceCost(500.f);
        filmDto.setRating(25f);
        Assertions.assertEquals(id1, filmService.update(filmDto));
        List<FilmDto> films = filmService.read();
        Assertions.assertEquals(3, films.size());
        FilmDto dto = filmService.findById(id1);
        Assertions.assertEquals(filmDto.getLicenceCost(), dto.getLicenceCost());
        Assertions.assertEquals(filmDto.getRating(), dto.getRating());
        Assertions.assertEquals(filmDto.getDuration(), dto.getDuration());
        Assertions.assertEquals(filmDto.getStartDate(), dto.getStartDate());
        Assertions.assertEquals(filmDto.getAgeRestrictions(), dto.getAgeRestrictions());
        FilmDto dto2 = filmService.findById(id2);
        Assertions.assertNotEquals(title, dto2.getTitle());
        FilmDto dto3 = filmService.findById(id3);
        Assertions.assertNotEquals(title, dto3.getTitle());
    }

    public FilmDto newFilmDto() {
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
        return dto;
    }
}
