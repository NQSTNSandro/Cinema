package com.example.demo.mapper;

import com.example.demo.DTO.SessionDto;
import com.example.demo.moduls.Session;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.MANDATORY)
@AllArgsConstructor
public class SessionMapper extends MapperInterface<Session, SessionDto> {
    private final RoomMapper roomMapper;

    @Override
    public Session dtoToEntity(SessionDto dto) {
        Session session_=new Session();
        session_.setCost((dto.getCost()));
        session_.setDate(dto.getDate());
        session_.setId(dto.getId());
        session_.setFilm(dto.getFilm());
        /*session_.setRooms(roomMapper.dtosToEntities(dto.getRooms()));*/
        session_.setRoomId(1);
        return session_;
    }

    @Override
    public SessionDto entityToDto(Session session_) {
        SessionDto sessionDto=new SessionDto();
        sessionDto.setCost(session_.getCost());
        sessionDto.setDate(session_.getDate());
        sessionDto.setId(session_.getId());
        sessionDto.setFilm(session_.getFilm());
        /*sessionDto.setRooms(roomMapper.entitiesToDtos(session_.getRooms()));*/
        return sessionDto;
    }
}
