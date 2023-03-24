package com.example.demo.mapper;

import com.example.demo.DTO.ClientDto;
import com.example.demo.moduls.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper extends MapperInterface<Client, ClientDto> {
    @Override
    public Client dtoToEntity(ClientDto dto) {
        Client client=new Client();
        client.setId(dto.getId());
        client.setAddress(dto.getAddress());
        client.setEmail(dto.getEmail());
        client.setInn(dto.getInn());
        client.setKpp(dto.getKpp());
        client.setPhone(dto.getPhone());
        client.setTitle(dto.getTitle());
        client.setType(dto.isType());
        client.setOgrnip(dto.getOgrnip());
        return client;
    }

    @Override
    public ClientDto entityToDto(Client client) {
        ClientDto clientDto=new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setAddress(client.getAddress());
        clientDto.setEmail(client.getEmail());
        clientDto.setInn(client.getInn());
        clientDto.setKpp(client.getKpp());
        clientDto.setPhone(client.getPhone());
        clientDto.setTitle(client.getTitle());
        clientDto.setType(client.isType());
        clientDto.setOgrnip(client.getOgrnip());
        return clientDto;
    }
}
