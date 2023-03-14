package com.example.demo.services;

import com.example.demo.DTO.AdTypeDto;
import com.example.demo.mapper.AdTypeMapper;
import com.example.demo.moduls.AdType;
import com.example.demo.repositories.AdTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class AdTypeService extends ServiceInterface<AdType,AdTypeRepository,AdTypeMapper,AdTypeDto> {


    public AdTypeService(AdTypeRepository repository, AdTypeMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public int save(AdTypeDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }
}
