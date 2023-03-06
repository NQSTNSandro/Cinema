package com.example.demo.mapper;

import com.example.demo.DTO.RowDto;
import com.example.demo.moduls.Row_;
import org.springframework.stereotype.Service;

@Service
public class RowMapper extends MapperInterface<Row_, RowDto> {
    @Override
    public Row_ dtoToEntity(RowDto dto) {
        return null;
    }

    @Override
    public RowDto entityToDto(Row_ row_) {
        return null;
    }
}
