package com.example.demo.services;

import com.example.demo.DTO.FilmDTO;
import com.example.demo.exception.BadInputException;
import com.example.demo.mapper.FilmMapper;
import com.example.demo.repositories.ActorRepository;
import com.example.demo.repositories.FilmRepository;
import lombok.AllArgsConstructor;
import com.example.demo.moduls.Film;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;
    private final ActorRepository actorRepository;
    private final FilmMapper mapper;
    @Transactional
    public int save(FilmDTO dto){
        Film film=mapper.dtoToEntity(dto);
        film.setActors(new HashSet<>(actorRepository.saveAll(film.getActors())));
        return filmRepository.save(film).getId();
    }
    @Transactional
    public List<FilmDTO> read(){
        List<Film> film = filmRepository.findAll();
        List<FilmDTO> dtos=new ArrayList<>();
        for(Film f: film) {
            dtos.add(mapper.entityToDto(f));
        }
        return dtos;
    }
    public int update(FilmDTO dto){
        if(filmRepository.existsById(dto.getId())){
            Film film= mapper.dtoToEntity(dto);
            film.setId(dto.getId());

            return filmRepository.save(film).getId();
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

    public int patch(FilmDTO dto) {
        if(filmRepository.existsById(dto.getId())){
            Film film= filmRepository.getById(dto.getId());
            if(dto.getStartDate()!=null)
                film.setStartDate(dto.getStartDate());
            if(dto.getRating()!=null)
                film.setRating(dto.getRating());
            return filmRepository.save(film).getId();
        }
        throw new BadInputException(String.format("Ненайден фильм по id: %d",dto.getId()));
    }
}
