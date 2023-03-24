package com.example.demo.mapper;

import com.example.demo.DTO.ActorDto;
import com.example.demo.moduls.Actor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ActorMapper {
    public Actor dtoToEntity(ActorDto dto){
        Actor actor=new Actor();
        actor.setId(dto.getId());
        actor.setFio(dto.getFio());
        return actor;
    }
    public Set<Actor> dtosToEntities(Set<ActorDto> actorDtos){
        return actorDtos.stream().map(this::dtoToEntity).collect(Collectors.toSet());
    }

    public ActorDto entityToDto(Actor actor){
        ActorDto actorDTO=new ActorDto();
        actorDTO.setId(actor.getId());
        actorDTO.setFio(actor.getFio());
        return actorDTO;
    }
    public Set<ActorDto> entitiesToDtos(Set<Actor> actors) {
        return actors.stream().map(this::entityToDto).collect(Collectors.toSet());
    }
}
