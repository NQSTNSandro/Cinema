package com.example.demo.mapper;

import com.example.demo.DTO.GenreDto;
import com.example.demo.moduls.Genre;
import org.springframework.stereotype.Service;

@Service
public class GenreMapper extends MapperInterface<Genre, GenreDto> {
    @Override
    public Genre dtoToEntity(GenreDto dto) {
        Genre genre=new Genre();
        genre.setId(dto.getId());
        genre.setType(dto.getType());
        return genre;
    }

    @Override
    public GenreDto entityToDto(Genre genre) {
        GenreDto genreDto=new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setType(genre.getType());
        return genreDto;
    }
}
