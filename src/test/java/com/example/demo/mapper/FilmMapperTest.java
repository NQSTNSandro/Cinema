package com.example.demo.mapper;

import com.example.demo.DTO.ActorDto;
import com.example.demo.DTO.FilmDto;
import com.example.demo.moduls.Actor;
import com.example.demo.moduls.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FilmMapperTest {
    @Autowired
    private FilmMapper filmMapper;
    @Test
    void noTransactionErrorCheck(){
        Film film=getNewFilm();
        Assertions.assertThrows(IllegalTransactionStateException.class,()->filmMapper.entityToDto(film));
    }

    @Test
    @Transactional
    void entityToDto() {
        Film film = getNewFilm();
        FilmDto filmDto = filmMapper.entityToDto(film);
        Assertions.assertEquals(film.getId(),filmDto.getId());
        Assertions.assertEquals(film.getRating(),filmDto.getRating());
        Assertions.assertEquals(film.getDuration(),filmDto.getDuration());
        Assertions.assertEquals(film.getTitle(),filmDto.getTitle());
        Assertions.assertEquals(film.getAgeRestrictions(),filmDto.getAgeRestrictions());
        Assertions.assertEquals(film.getStartDate(),filmDto.getStartDate());
    }

    @Transactional
    @Test
    void actorsMappingTest(){
        Film film=getNewFilm();
        film.setActors(Set.of(getNewActor(Set.of(film))));
        FilmDto filmDto= filmMapper.entityToDto(film);
        Assertions.assertEquals(1,filmDto.getActors().size());
    }



    @Test
    void dtoToEntity() {
    }
    private Film getNewFilm() {
        Film film = new Film();
        film.setId(1);
        film.setRating(16);
        film.setDuration(3600);
        film.setTitle("1234");
        film.setAgeRestrictions(16);
        film.setStartDate(LocalDate.now());
        return film;
    }

    private Actor getNewActor(Set<Film> films) {
        Actor actor = new Actor();
        actor.setId(1);
        actor.setFio("SSS");
        actor.setFilms(films);
        return actor;
    }
}