package com.example.demo.mapper;

import com.example.demo.DTO.FilmDTO;
import com.example.demo.moduls.Film;
import org.springframework.stereotype.Service;

@Service
public class FilmMapper {
    public FilmDTO entityToDto(Film film) {
        FilmDTO dto = new FilmDTO();
        dto.setAgeRestrictions(film.getAgeRestrictions());
        dto.setDuration(film.getDuration());
        dto.setLicenceCost(film.getLicenceCost());
        dto.setTitle(film.getTitle());
        dto.setRating(film.getRating());
        dto.setStartDate(film.getStartDate());
        return dto;
    }

    public Film dtoToEntity(FilmDTO dto) {
        Film film = new Film();
        film.setAgeRestrictions(dto.getAgeRestrictions());
        film.setDuration(dto.getDuration());
        film.setLicenceCost(dto.getLicenceCost());
        film.setTitle(dto.getTitle());
        film.setRating(dto.getRating());
        film.setStartDate(dto.getStartDate());
        return film;
    }

}
