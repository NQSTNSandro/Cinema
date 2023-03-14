package com.example.demo.services;

import com.example.demo.DTO.GenreDto;
import com.example.demo.mapper.GenreMapper;
import com.example.demo.moduls.Genre;
import com.example.demo.repositories.GenreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenreService extends ServiceInterface<Genre,GenreRepository, GenreMapper, GenreDto> {

    public GenreService(GenreRepository genreRepository, GenreMapper genreMapper) {
        super(genreRepository, genreMapper);
    }
    @Transactional

    @Override
    public int save(GenreDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }
}
