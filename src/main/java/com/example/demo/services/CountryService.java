package com.example.demo.services;

import com.example.demo.DTO.CountryDto;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.moduls.Country;
import com.example.demo.repositories.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends ServiceInterface<Country, CountryRepository, CountryMapper, CountryDto> {
    public CountryService(CountryRepository repository, CountryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public int save(CountryDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }
}
