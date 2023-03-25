package com.example.demo.services;

import com.example.demo.DTO.SessionDto;
import com.example.demo.exception.BadInputException;
import com.example.demo.mapper.SessionMapper;
import com.example.demo.moduls.Row;
import com.example.demo.moduls.Session;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.repositories.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService extends ServiceInterface<Session,SessionRepository,SessionMapper,SessionDto> {

    public SessionService(SessionRepository repository, SessionMapper mapper) {
        super(repository, mapper);
    }

    @Transactional
    @Override
    public int save(SessionDto dto){
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }

    @Override
    public int update(SessionDto dto) {
        if(repository.existsById(dto.getId())){
            Session session= mapper.dtoToEntity(dto);
            session.setId(dto.getId());
            return repository.save(session).getId();
        }
        throw new BadInputException(String.format("Ненайден сеанс по id: %d",dto.getId()));
    }
}
