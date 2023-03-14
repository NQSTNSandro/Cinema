package com.example.demo.services;

import com.example.demo.DTO.RoomDto;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    public Set<RoomDto> read(){
        return roomMapper.entitiesToDtos(new HashSet<>(roomRepository.findAll()));
    }

}
