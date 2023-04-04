package com.example.demo.services;

import com.example.demo.DTO.ActorDto;
import com.example.demo.exception.BadInputException;
import com.example.demo.mapper.ActorMapper;
import com.example.demo.moduls.Actor;
import com.example.demo.repositories.ActorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActorService extends ServiceInterface<Actor, ActorRepository, ActorMapper, ActorDto> {

    public ActorService(ActorRepository repository, ActorMapper mapper) {
        super(repository, mapper);
    }

    @Transactional
    @Override
    public int save(ActorDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }

    @Override
    public int update(ActorDto dto) {
        if (repository.existsById(dto.getId())) {
            Actor actor = mapper.dtoToEntity(dto);
            actor.setId(dto.getId());
            return repository.save(actor).getId();
        }
        throw new BadInputException(String.format("Ненайден сеанс по id: %d", dto.getId()));
    }
}
