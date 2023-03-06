package com.example.demo.mapper;

import com.example.demo.DTO.RoomDto;
import com.example.demo.moduls.Room;
import org.springframework.stereotype.Service;

@Service
public class RoomMapper extends MapperInterface<Room, RoomDto> {
    @Override
    public Room dtoToEntity(RoomDto dto) {
        Room room=new Room();
        room.setId(dto.getId());
        room.setNumber(dto.getNumber());
        room.setProjector(dto.getProjector());
        room.setType(dto.getType());
        room.setTotalPlaces(dto.getTotalPlaces());

        return room;
    }

    @Override
    public RoomDto entityToDto(Room room) {
        RoomDto roomDto=new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setNumber(room.getNumber());
        roomDto.setProjector(room.getProjector());
        roomDto.setType(room.getType());
        roomDto.setTotalPlaces(room.getTotalPlaces());
        return roomDto;
    }
}
