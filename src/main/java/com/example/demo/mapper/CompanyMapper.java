package com.example.demo.mapper;

import com.example.demo.DTO.CompanyDto;
import com.example.demo.moduls.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper extends MapperInterface<Company,CompanyDto>{

    @Override
    public Company dtoToEntity(CompanyDto dto) {
        Company company=new Company();
        company.setId(dto.getId());
        company.setName(dto.getName());
        company.setFoundation(dto.getFoundation());
        return company;
    }
    @Override
    public CompanyDto entityToDto(Company company) {
        CompanyDto companyDto=new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setFoundation(company.getFoundation());
        return companyDto;
    }
}
