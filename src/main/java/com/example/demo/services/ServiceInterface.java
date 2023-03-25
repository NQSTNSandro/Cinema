package com.example.demo.services;

import com.example.demo.mapper.MapperInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public abstract class ServiceInterface<C,R extends JpaRepository ,M extends MapperInterface ,D> {
    protected final R repository;
    protected final M mapper;
    public abstract int save(D dto);
    public List<D> read(){
        List<C> clazz = repository.findAll();
        List<D> dtos=new ArrayList<>();
        for(C c: clazz) {
            dtos.add((D) mapper.entityToDto(c));
        }
        return dtos;
    }
    public int remove(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        return id;
    }
    public abstract int update(D dto);


}
