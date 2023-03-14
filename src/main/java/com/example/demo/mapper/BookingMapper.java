package com.example.demo.mapper;

import com.example.demo.DTO.BookingDto;
import com.example.demo.moduls.Booking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingMapper extends MapperInterface<Booking, BookingDto> {
    private final SessionMapper sessionMapper;
    private final RowMapper rowMapper;
    @Override
    public Booking dtoToEntity(BookingDto dto) {
        Booking booking=new Booking();
        booking.setId(dto.getId());
        booking.setPlace(dto.getPlace());
        booking.setPrice(dto.getPrice());
        booking.setType(dto.isType());
        booking.setSession(sessionMapper.dtoToEntity(dto.getSession()));
        booking.setRow(rowMapper.dtoToEntity(dto.getRow()));
        return booking;
    }

    @Override
    public BookingDto entityToDto(Booking booking) {
        BookingDto bookingDto=new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setPlace(booking.getPlace());
        bookingDto.setPrice(booking.getPrice());
        bookingDto.setType(booking.isType());
        bookingDto.setSession(sessionMapper.entityToDto(booking.getSession()));
        bookingDto.setRow(rowMapper.entityToDto(booking.getRow()));
        return bookingDto;
    }
}
