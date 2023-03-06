package com.example.demo.mapper;

import com.example.demo.DTO.TicketDto;
import com.example.demo.moduls.Ticket_;
import org.springframework.stereotype.Service;

@Service
public class TicketMapper extends MapperInterface<Ticket_, TicketDto> {
    @Override
    public Ticket_ dtoToEntity(TicketDto dto) {
        return null;
    }

    @Override
    public TicketDto entityToDto(Ticket_ ticket_) {
        return null;
    }
}
