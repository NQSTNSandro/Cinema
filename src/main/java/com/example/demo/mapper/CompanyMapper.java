package com.example.demo.mapper;

import com.example.demo.DTO.CompanyDto;
import com.example.demo.moduls.Company;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class CompanyMapper{


    public Company dtoToEntity(CompanyDto dto) {
        Company company=new Company();
        company.setId(dto.getId());
        company.setName(dto.getName());
        company.setFoundation(dto.getFoundation());
        return company;
    }


    public  Set<Company> dtosToEntities(Set<CompanyDto> dtos) {
        return dtos.stream().map(this::dtoToEntity).collect(Collectors.toSet());
    }


    public CompanyDto entityToDto(Company company) {
        CompanyDto companyDto=new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setFoundation(company.getFoundation());
        return companyDto;
    }


    public  Set<CompanyDto> entitiesToDtos(Set<Company> companies) {
        return companies.stream().map(this::entityToDto).collect(Collectors.toSet());    }
}
