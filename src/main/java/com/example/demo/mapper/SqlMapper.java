package com.example.demo.mapper;

import com.example.demo.DTO.FilmDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SqlMapper {

    public List<FilmDto> setToDto(Set<Object[]> winterFilms, Class<FilmDto> filmDtoClass) {
        List<FilmDto> list=new ArrayList<>();
        for(Object[] a: winterFilms){
            FilmDto filmDto=new FilmDto();
            filmDto.setId((Integer) a[0]);
            filmDto.setTitle((String) a[1]);
            list.add(filmDto);
        }
        return list;
    }
}
