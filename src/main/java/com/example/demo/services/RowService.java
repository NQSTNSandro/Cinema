package com.example.demo.services;

import com.example.demo.DTO.RowDto;
import com.example.demo.mapper.RowMapper;
import com.example.demo.moduls.Row;
import com.example.demo.repositories.RowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RowService extends ServiceInterface<Row,RowRepository, RowMapper, RowDto> {
    public RowService(RowRepository rowRepository, RowMapper rowMapper) {
        super(rowRepository, rowMapper);
    }
    @Transactional

    @Override
    public int save(RowDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }
}
