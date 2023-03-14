package com.example.demo.mapper;

import com.example.demo.DTO.RowDto;
import com.example.demo.moduls.Row;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RowMapper extends MapperInterface<Row, RowDto> {
    private final RoomMapper roomMapper;

    @Override
    public Row dtoToEntity(RowDto dto) {
        Row row = new Row();
        row.setId(dto.getId());
        row.setNumber(dto.getNumber());
        row.setPlaces(dto.getPlaces());
        row.setTicketCostMp(dto.getTicketCostMp());
        row.setRoom(roomMapper.dtoToEntity(dto.getRoom()));
        return row;
    }

    @Override
    public RowDto entityToDto(Row row) {
        RowDto rowDto = new RowDto();
        rowDto.setPlaces(row.getPlaces());
        rowDto.setId(row.getId());
        rowDto.setNumber(row.getNumber());
        rowDto.setTicketCostMp(row.getTicketCostMp());
        rowDto.setRoom(roomMapper.entityToDto(row.getRoom()));
        return rowDto;
    }
}
