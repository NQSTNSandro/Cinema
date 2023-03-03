package com.example.demo.mapper;

import com.example.demo.DTO.FilmDTO;
import com.example.demo.moduls.Film;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation = Propagation.MANDATORY)
@Service
@AllArgsConstructor
public class FilmMapper {
    private final ActorMapper actorMapper;

    public FilmDTO entityToDto(Film film) {
        FilmDTO dto = new FilmDTO();
        dto.setId(film.getId());
        dto.setAgeRestrictions(film.getAgeRestrictions());
        dto.setDuration(film.getDuration());
        dto.setLicenceCost(film.getLicenceCost());
        dto.setTitle(film.getTitle());
        dto.setRating(film.getRating());
        dto.setStartDate(film.getStartDate());
        dto.setActors(actorMapper.entitiesToDtos(film.getActors()));
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
        film.setActors(actorMapper.dtosToEntities(dto.getActors()));
        return film;
    }

}
