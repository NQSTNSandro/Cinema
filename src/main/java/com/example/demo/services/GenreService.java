package com.example.demo.services;

import com.example.demo.DTO.GenreDto;
import com.example.demo.mapper.GenreMapper;
import com.example.demo.moduls.Genre;
import com.example.demo.repositories.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends ServiceInterface<Genre,GenreRepository, GenreMapper, GenreDto> {

    public GenreService(GenreRepository genreRepository, GenreMapper genreMapper) {
        super(genreRepository, genreMapper);
    }

    @Override
    public int save(GenreDto genreDto) {
        return repository.save(mapper.dtoToEntity(genreDto)).getId();
    }
}
