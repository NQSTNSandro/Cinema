package com.example.demo.mapper;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class MapperInterface<T, D> {
    public abstract T dtoToEntity(D dto);


    public Set<T> dtosToEntities(Set<D> dtos) {
        return dtos.stream().map(this::dtoToEntity).collect(Collectors.toSet());
    }

    public abstract D entityToDto(T t);

    public Set<D> entitiesToDtos(Set<T> t) {
        return t.stream().map(this::entityToDto).collect(Collectors.toSet());
    }
}
