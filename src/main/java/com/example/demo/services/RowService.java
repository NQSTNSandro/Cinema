package com.example.demo.services;

import com.example.demo.DTO.RowDto;
import com.example.demo.mapper.RowMapper;
import com.example.demo.moduls.Row;
import com.example.demo.repositories.RowRepository;
import org.springframework.stereotype.Service;

@Service
public class RowService extends ServiceInterface<Row,RowRepository, RowMapper, RowDto> {
    public RowService(RowRepository rowRepository, RowMapper rowMapper) {
        super(rowRepository, rowMapper);
    }

    @Override
    public int save(RowDto rowDto) {
        return repository.save(mapper.dtoToEntity(rowDto)).getId();
    }
}
