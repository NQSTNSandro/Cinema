package com.example.demo.services;

import com.example.demo.DTO.FilmDTO;
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
    public boolean update(FilmDTO dto, int id){
        if(filmRepository.existsById(id)){
            Film film= filmRepository.findById(id).get();
            film= mapper.dtoToEntity(dto);
            filmRepository.save(film);
            return true;
        }
        return false;
    }
    public boolean remove(int id){
        if(filmRepository.existsById(id)){
            filmRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
