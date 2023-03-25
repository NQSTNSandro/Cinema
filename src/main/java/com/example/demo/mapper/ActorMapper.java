package com.example.demo.mapper;

import com.example.demo.DTO.ActorDto;
import com.example.demo.moduls.Actor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ActorMapper extends MapperInterface<Actor,ActorDto> {
    @Override
    public Actor dtoToEntity(ActorDto dto) {
        Actor actor = new Actor();
        actor.setId(dto.getId());
        actor.setFio(dto.getFio());
        return actor;
    }
    @Override

    public ActorDto entityToDto(Actor actor) {
        ActorDto actorDTO = new ActorDto();
        actorDTO.setId(actor.getId());
        actorDTO.setFio(actor.getFio());
        return actorDTO;
    }
}

