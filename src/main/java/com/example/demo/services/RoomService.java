package com.example.demo.services;

import com.example.demo.DTO.GenreDto;
import com.example.demo.DTO.RoomDto;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.moduls.Room;
import com.example.demo.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoomService extends ServiceInterface<Room, RoomRepository, RoomMapper, RoomDto> {
    public RoomService(RoomRepository repository, RoomMapper mapper) {
        super(repository, mapper);
    }
    @Transactional

    @Override
    public int save(RoomDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }


}
