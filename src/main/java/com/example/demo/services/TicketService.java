package com.example.demo.services;

import com.example.demo.DTO.TicketDto;
import com.example.demo.mapper.TicketMapper;
import com.example.demo.moduls.Ticket;
import com.example.demo.repositories.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends ServiceInterface<Ticket,TicketRepository, TicketMapper, TicketDto> {

    public TicketService(TicketRepository repository, TicketMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public int save(TicketDto ticketDto) {
        return repository.save(mapper.dtoToEntity(ticketDto)).getId();
    }
}
