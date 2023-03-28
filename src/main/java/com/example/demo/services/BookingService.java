package com.example.demo.services;

import com.example.demo.DTO.BookingDto;
import com.example.demo.exception.BadInputException;
import com.example.demo.mapper.BookingMapper;
import com.example.demo.moduls.AdType;
import com.example.demo.moduls.Booking;
import com.example.demo.moduls.Row;
import com.example.demo.moduls.Session;
import com.example.demo.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService extends ServiceInterface<Booking, BookingRepository, BookingMapper, BookingDto> {

    private SessionService sessionService;
    private RowService rowService;

    public BookingService(BookingRepository repository, BookingMapper mapper, SessionService sessionService, RowService rowService) {
        super(repository, mapper);
        this.sessionService = sessionService;
        this.rowService = rowService;
    }

    @Transactional
    @Override
    public int save(BookingDto dto) {
        Booking booking = mapper.dtoToEntity(dto);
        float cost = (booking.getRow().getTicketCostMp() * booking.getSession().getCost());
        Session session = sessionService.getSessionById(booking.getSession().getId());
        Row row = rowService.getRowById(booking.getRow().getId());
        if (cost == session.getCost() * row.getTicketCostMp()) {
            booking.setPrice(cost);
            return repository.save(booking).getId();
        }
        else throw new BadInputException();
    }

    @Transactional
    @Override
    public List<BookingDto> read() {
        return super.read();
    }

    @Override
    public int update(BookingDto dto) {
        if (repository.existsById(dto.getId())) {
            Booking booking = mapper.dtoToEntity(dto);
            booking.setId(dto.getId());
            return repository.save(booking).getId();
        }
        throw new BadInputException(String.format("Ненайдена запись по id: %d", dto.getId()));
    }
}
