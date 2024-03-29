package com.example.demo.services;

import com.example.demo.DTO.AdTypeDto;
import com.example.demo.exception.BadInputException;
import com.example.demo.mapper.AdTypeMapper;
import com.example.demo.moduls.AdType;
import com.example.demo.repositories.AdTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdTypeService extends ServiceInterface<AdType, AdTypeRepository, AdTypeMapper, AdTypeDto> {


    public AdTypeService(AdTypeRepository repository, AdTypeMapper mapper) {
        super(repository, mapper);
    }

    @Transactional

    @Override
    public int save(AdTypeDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }

    @Override
    public int update(AdTypeDto dto) {
        if(repository.existsById(dto.getId())){
            AdType adType= mapper.dtoToEntity(dto);
            adType.setId(dto.getId());
            return repository.save(adType).getId();
        }
        throw new BadInputException(String.format("Ненайдена реклама по id: %d",dto.getId()));

    }
}
