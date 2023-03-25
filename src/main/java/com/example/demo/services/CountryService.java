package com.example.demo.services;

import com.example.demo.DTO.CountryDto;
import com.example.demo.exception.BadInputException;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.moduls.AdType;
import com.example.demo.moduls.Country;
import com.example.demo.repositories.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService extends ServiceInterface<Country, CountryRepository, CountryMapper, CountryDto> {
    public CountryService(CountryRepository repository, CountryMapper mapper) {
        super(repository, mapper);
    }
    @Transactional

    @Override
    public int save(CountryDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }

    @Override
    public int update(CountryDto dto) {
        if(repository.existsById(dto.getId())){
            Country country= mapper.dtoToEntity(dto);
            country.setId(dto.getId());
            return repository.save(country).getId();
        }
        throw new BadInputException(String.format("Ненайдена страна по id: %d",dto.getId()));
    }
}
