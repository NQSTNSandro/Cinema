package com.example.demo.services;

import com.example.demo.repositories.FilmRepository;
import lombok.RequiredArgsConstructor;
import com.example.demo.moduls.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FilmService {

    @Autowired
    private final FilmRepository filmRepository;

    public void save(){
        Film film=new Film();
        film.setAgeRestrictions(16);
        film.setDuration(60);
        film.setLicenceCost(50.5F);
        film.setTitle("Винни пух");
        film.setRating(10);
        film.setStartDate(LocalDate.now());
        filmRepository.save(film);
        System.out.println("Ok");
    }

    /*@Scheduled(fixedRateString = "1000000")
    public void requestSessions() {
        save();
    }*/
}
