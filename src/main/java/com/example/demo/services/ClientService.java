package com.example.demo.services;

import com.example.demo.DTO.ClientDto;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.moduls.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends ServiceInterface<Client, ClientRepository, ClientMapper, ClientDto> {
    public ClientService(ClientRepository repository, ClientMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public int save(ClientDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }
}
