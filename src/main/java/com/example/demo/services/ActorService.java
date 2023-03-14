package com.example.demo.services;

import com.example.demo.DTO.ActorDto;
import com.example.demo.mapper.ActorMapper;
import com.example.demo.moduls.Actor;
import com.example.demo.repositories.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ActorService {
    private final ActorRepository repository;
    private final ActorMapper mapper;
    @Transactional

    public int addActor(ActorDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }
}
