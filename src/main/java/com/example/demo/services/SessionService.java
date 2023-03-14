package com.example.demo.services;

import com.example.demo.DTO.SessionDto;
import com.example.demo.mapper.SessionMapper;
import com.example.demo.moduls.Session;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.repositories.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;
    private final SessionMapper mapper;
    @Transactional
    public int save(SessionDto sessionDto){
        Session session_= mapper.dtoToEntity(sessionDto);
        return sessionRepository.save(session_).getId();
    }
    @Transactional
    public List<SessionDto> read(){
        List<Session> session_s = sessionRepository.findAll();
        List<SessionDto> dtos=new ArrayList<>();
        for(Session f: session_s) {
            dtos.add(mapper.entityToDto(f));
        }
        return dtos;
    }
}
