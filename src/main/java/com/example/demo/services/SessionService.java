package com.example.demo.services;

import com.example.demo.DTO.SessionDto;
import com.example.demo.exception.BadInputException;
import com.example.demo.mapper.SessionMapper;
import com.example.demo.moduls.Session;
import com.example.demo.repositories.SessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Override
    public List<SessionDto> read() {
        return super.read();
    }

    @Transactional
    public Session getSessionById(int id){
        if(repository.existsById(id)){
            return repository.getReferenceById(id);
        }
        throw new BadInputException(String.format("запись не найдена: %d", id));
    }
}
