package com.example.demo.services;

import com.example.demo.DTO.CompanyDto;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.moduls.Company;
import com.example.demo.repositories.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService extends ServiceInterface<Company, CompanyRepository, CompanyMapper, CompanyDto> {
    public CompanyService(CompanyRepository repository, CompanyMapper mapper) {
        super(repository, mapper);
    }
    @Transactional

    @Override
    public int save(CompanyDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }
}
