package com.example.demo.services;

import com.example.demo.DTO.DirectorDto;
import com.example.demo.mapper.DirectorMapper;
import com.example.demo.moduls.Director;
import com.example.demo.repositories.DirectorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DirectorService extends ServiceInterface<Director, DirectorRepository, DirectorMapper, DirectorDto> {
    public DirectorService(DirectorRepository repository, DirectorMapper mapper) {
        super(repository, mapper);
    }
    @Transactional

    @Override
    public int save(DirectorDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }
}
