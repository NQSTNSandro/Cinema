package com.example.demo.mapper;

import com.example.demo.DTO.TicketDto;
import com.example.demo.moduls.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketMapper extends MapperInterface<Ticket, TicketDto> {
    @Override
    public Ticket dtoToEntity(TicketDto dto) {
        Ticket ticket=new Ticket();
        ticket.setId(dto.getId());
        ticket.setTicketNumber(dto.getTicketNumber());
        return ticket;
    }

    @Override
    public TicketDto entityToDto(Ticket ticket) {
        TicketDto ticketDto=new TicketDto();
        ticketDto.setId(ticketDto.getId());
        ticketDto.setTicketNumber(ticket.getTicketNumber());
        return ticketDto;
    }
}
