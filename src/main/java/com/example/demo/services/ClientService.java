package com.example.demo.services;

import com.example.demo.DTO.ClientDto;
import com.example.demo.exception.BadInputException;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.moduls.AdType;
import com.example.demo.moduls.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService extends ServiceInterface<Client, ClientRepository, ClientMapper, ClientDto> {
    public ClientService(ClientRepository repository, ClientMapper mapper) {
        super(repository, mapper);
    }
    @Transactional

    @Override
    public int save(ClientDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }

    @Override
    public int update(ClientDto dto) {
        if(repository.existsById(dto.getId())){
            Client client= mapper.dtoToEntity(dto);
            client.setId(dto.getId());
            return repository.save(client).getId();
        }
        throw new BadInputException(String.format("Ненайден заказчик по id: %d",dto.getId()));
    }
}
