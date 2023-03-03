package com.example.demo.services;

import com.example.demo.DTO.FilmDTO;
import com.example.demo.exception.BadInputException;
import com.example.demo.mapper.FilmMapper;
import com.example.demo.repositories.FilmRepository;
import lombok.AllArgsConstructor;
import com.example.demo.moduls.Film;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;
    private final FilmMapper mapper;

    public int save(FilmDTO dto){
        return filmRepository.save(mapper.dtoToEntity(dto)).getId();
    }

    public ArrayList<Film> read(){
        return new ArrayList<>(filmRepository.findAll());
    }
    public boolean update(FilmDTO dto){
        if(filmRepository.existsById(dto.getId())){
            Film film= mapper.dtoToEntity(dto);
            film.setId(dto.getId());
            filmRepository.save(film);
            return true;
        }
        throw new BadInputException(String.format("Ненайден фильм по id: %d",dto.getId()));
    }
    public int remove(int id){
        if(filmRepository.existsById(id)){
            filmRepository.deleteById(id);
            return id;
        }
        throw new BadInputException(String.format("Ненайден фильм по id: %d",id));
    }
}
