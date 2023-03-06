package com.example.demo.mapper;

import com.example.demo.DTO.BookingDto;
import com.example.demo.moduls.Booking_;
import org.springframework.stereotype.Service;

@Service
public class BookingMapper extends MapperInterface<Booking_, BookingDto> {
    @Override
    public Booking_ dtoToEntity(BookingDto dto) {
        return null;
    }

    @Override
    public BookingDto entityToDto(Booking_ booking_) {
        return null;
    }
}
