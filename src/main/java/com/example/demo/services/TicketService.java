package com.example.demo.services;

import com.example.demo.DTO.TicketDto;
import com.example.demo.exception.BadInputException;
import com.example.demo.mapper.TicketMapper;
import com.example.demo.moduls.Session;
import com.example.demo.moduls.Ticket;
import com.example.demo.repositories.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService extends ServiceInterface<Ticket,TicketRepository, TicketMapper, TicketDto> {

    public TicketService(TicketRepository repository, TicketMapper mapper) {
        super(repository, mapper);
    }
    @Transactional
    @Override
    public int save(TicketDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }

    @Override
    public int update(TicketDto dto) {
        if(repository.existsById(dto.getId())){
            Ticket ticket= mapper.dtoToEntity(dto);
            ticket.setId(dto.getId());
            return repository.save(ticket).getId();
        }
        throw new BadInputException(String.format("Ненайден билет по id: %d",dto.getId()));
    }
}
