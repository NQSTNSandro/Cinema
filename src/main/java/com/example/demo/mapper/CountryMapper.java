package com.example.demo.mapper;

import com.example.demo.DTO.CountryDto;
import com.example.demo.moduls.Country;
import org.springframework.stereotype.Service;


@Service
public class CountryMapper extends MapperInterface<Country, CountryDto> {

    @Override
    public Country dtoToEntity(CountryDto dto) {
        Country country = new Country();
        country.setId(dto.getId());
        country.setName(dto.getName());
        return country;
    }

    @Override
    public CountryDto entityToDto(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        return countryDto;
    }
}
