package com.example.demo.mapper;


import com.example.demo.DTO.TicketDto;
import com.example.demo.moduls.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketMapper extends MapperInterface<Ticket, TicketDto> {
    private final BookingMapper bookingMapper;
    @Override
    public Ticket dtoToEntity(TicketDto dto) {
        Ticket ticket=new Ticket();
        ticket.setId(dto.getId());
        ticket.setTicketNumber(dto.getTicketNumber());
        ticket.setBooking(bookingMapper.dtoToEntity(dto.getBooking()));
        return ticket;
    }

    @Override
    public TicketDto entityToDto(Ticket ticket) {
        TicketDto ticketDto=new TicketDto();
        ticketDto.setId(ticketDto.getId());
        ticketDto.setTicketNumber(ticket.getTicketNumber());
        ticketDto.setBooking(bookingMapper.entityToDto(ticket.getBooking()));
        return ticketDto;
    }
}
