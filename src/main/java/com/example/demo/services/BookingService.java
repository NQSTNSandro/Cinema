package com.example.demo.services;

import com.example.demo.DTO.BookingDto;
import com.example.demo.mapper.BookingMapper;
import com.example.demo.moduls.Booking;
import com.example.demo.repositories.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService extends ServiceInterface<Booking, BookingRepository, BookingMapper, BookingDto>{

    public BookingService(BookingRepository repository, BookingMapper mapper) {
        super(repository, mapper);
    }
    @Transactional
    @Override
    public int save(BookingDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }
    @Transactional
    @Override
    public List<BookingDto> read() {
        return super.read();
    }
}
