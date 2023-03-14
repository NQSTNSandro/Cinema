package com.example.demo.mapper;

import com.example.demo.DTO.AdvertisingDto;
import com.example.demo.moduls.Advertising;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdvertisingMapper extends MapperInterface<Advertising, AdvertisingDto> {
    private final AdTypeMapper adTypeMapper;
    private final ClientMapper clientMapper;
    @Override
    public Advertising dtoToEntity(AdvertisingDto dto) {
        Advertising advertising=new Advertising();
        advertising.setId(dto.getId());
        advertising.setDuration(dto.getDuration());
        advertising.setAdType(adTypeMapper.dtoToEntity(dto.getAdType()));
        advertising.setClient(clientMapper.dtoToEntity(dto.getClient()));
        return advertising;
    }

    @Override
    public AdvertisingDto entityToDto(Advertising advertising) {
        AdvertisingDto advertisingDto=new AdvertisingDto();
        advertisingDto.setDuration(advertising.getDuration());
        advertisingDto.setId(advertising.getId());
        advertisingDto.setAdType(adTypeMapper.entityToDto(advertising.getAdType()));
        return advertisingDto;
    }
}
