package com.example.demo.mapper;

import com.example.demo.DTO.AdTypeDto;
import com.example.demo.moduls.AdType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class AdTypeMapper extends MapperInterface<AdType, AdTypeDto> {
    @Override
    public AdType dtoToEntity(AdTypeDto dto) {
        AdType adType = new AdType();
        adType.setType(dto.getType());
        adType.setId(dto.getId());
        return adType;
    }

    @Override
    public AdTypeDto entityToDto(AdType adType) {
        AdTypeDto adTypeDto = new AdTypeDto();
        adTypeDto.setType(adType.getType());
        adTypeDto.setId(adType.getId());
        return adTypeDto;
    }
}
