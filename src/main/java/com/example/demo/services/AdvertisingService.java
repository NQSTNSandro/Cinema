package com.example.demo.services;


import com.example.demo.DTO.AdvertisingDto;
import com.example.demo.mapper.AdvertisingMapper;
import com.example.demo.moduls.Advertising;
import com.example.demo.repositories.AdvertisingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdvertisingService extends ServiceInterface<Advertising, AdvertisingRepository, AdvertisingMapper, AdvertisingDto> {
    public AdvertisingService(AdvertisingRepository repository, AdvertisingMapper mapper) {
        super(repository, mapper);
    }

    @Transactional
    @Override
    public int save(AdvertisingDto dto) {
        return repository.save(mapper.dtoToEntity(dto)).getId();
    }
}
