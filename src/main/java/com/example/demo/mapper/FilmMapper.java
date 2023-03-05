package com.example.demo.mapper;

import com.example.demo.DTO.FilmDto;
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
    private final CountryMapper countryMapper;
    private final CompanyMapper companyMapper;
    private final DirectorMapper directorMapper;
    private final GenreMapper genreMapper;

    public FilmDto entityToDto(Film film) {
        FilmDto dto = new FilmDto();
        dto.setId(film.getId());
        dto.setAgeRestrictions(film.getAgeRestrictions());
        dto.setDuration(film.getDuration());
        dto.setLicenceCost(film.getLicenceCost());
        dto.setTitle(film.getTitle());
        dto.setRating(film.getRating());
        dto.setStartDate(film.getStartDate());
        dto.setActors(actorMapper.entitiesToDtos(film.getActors()));
        dto.setCountries(countryMapper.entitiesToDtos(film.getCountries()));
        dto.setCompanies(companyMapper.entitiesToDtos(film.getCompanies()));
        dto.setDirectors(directorMapper.entitiesToDtos(film.getDirectors()));
        dto.setGenres(genreMapper.entitiesToDtos(film.getGenres()));
        return dto;
    }

    public Film dtoToEntity(FilmDto dto) {
        Film film = new Film();
        film.setAgeRestrictions(dto.getAgeRestrictions());
        film.setDuration(dto.getDuration());
        film.setLicenceCost(dto.getLicenceCost());
        film.setTitle(dto.getTitle());
        film.setRating(dto.getRating());
        film.setStartDate(dto.getStartDate());
        film.setActors(actorMapper.dtosToEntities(dto.getActors()));
        film.setCountries(countryMapper.dtosToEntities(dto.getCountries()));
        film.setCompanies(companyMapper.dtosToEntities(dto.getCompanies()));
        film.setDirectors(directorMapper.dtosToEntities(dto.getDirectors()));
        film.setGenres(genreMapper.dtosToEntities(dto.getGenres()));
        return film;
    }

}
