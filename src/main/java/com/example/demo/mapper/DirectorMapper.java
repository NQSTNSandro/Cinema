package com.example.demo.mapper;

import com.example.demo.DTO.DirectorDto;
import com.example.demo.moduls.Director;
import org.springframework.stereotype.Service;

@Service
public class DirectorMapper extends MapperInterface<Director, DirectorDto> {
    @Override
    public Director dtoToEntity(DirectorDto dto) {
        Director director=new Director();
        director.setFio(dto.getFio());
        director.setId(dto.getId());
        return director;
    }

    @Override
    public DirectorDto entityToDto(Director director) {
        DirectorDto directorDto=new DirectorDto();
        directorDto.setFio(director.getFio());
        directorDto.setId(director.getId());
        return directorDto;
    }
}
