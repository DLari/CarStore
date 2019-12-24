package ru.reksoft.interns.carstore.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.reksoft.interns.carstore.dto.DictCarcassDto;
import ru.reksoft.interns.carstore.entity.DictCarcass;

import java.util.Objects;

@Component
public class DictCarcassMapper {

    @Autowired
    private ModelMapper modelMapper;

    public DictCarcass toEntity(DictCarcassDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, DictCarcass.class);
    }

    public DictCarcassDto toDto(DictCarcass entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, DictCarcassDto.class);
    }

}
