package com.example.demo.services;

import com.example.demo.DTO.FilmDTO;
import com.example.demo.mapper.FilmMapper;
import com.example.demo.repositories.FilmRepository;
import lombok.AllArgsConstructor;
import com.example.demo.moduls.Film;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;
    private final FilmMapper mapper;

    public int save(FilmDTO dto){
        return filmRepository.save(mapper.dtoToEntity(dto)).getId();
    }



}
