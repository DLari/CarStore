package ru.reksoft.interns.carstore.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.reksoft.interns.carstore.dao.ColorRepository;
import ru.reksoft.interns.carstore.dto.ColorDto;
import ru.reksoft.interns.carstore.dto.SelectItemDto;
import ru.reksoft.interns.carstore.entity.Color;

import java.util.Objects;

@Component
public class ColorMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ColorRepository colorRepository;

    public Color toEntity(ColorDto dto) {
        return modelMapper.map(dto, Color.class);
    }

    public ColorDto toDto(Color entity) {
        return modelMapper.map(entity, ColorDto.class);
    }

    public SelectItemDto toSelectItemDto(ColorDto entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, SelectItemDto.class);
    }

    public  Color updateMapper (ColorDto colorDTO, Color color) {
        color.setName(colorDTO.getName());
        color.setPrice(colorDTO.getPrice());
    //    color.setRemoved(colorDTO.getRemoved());
//        colorRepository.saveAndFlush(color);
        return color;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
