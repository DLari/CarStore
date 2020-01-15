package ru.reksoft.interns.carstore.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.reksoft.interns.carstore.dao.ColorRepository;
import ru.reksoft.interns.carstore.dto.ColorDTO;
import ru.reksoft.interns.carstore.entity.Color;

@Component
public class ColorMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ColorRepository colorRepository;

    public Color toEntity(ColorDTO dto) {
        return modelMapper.map(dto, Color.class);
    }

    public ColorDTO toDto(Color entity) {
        return modelMapper.map(entity, ColorDTO.class);
    }

    public  Color updateMapper (ColorDTO colorDTO, Color color) {
        color.setName(colorDTO.getName());
        color.setPrice(colorDTO.getPrice());
    //    color.setRemoved(colorDTO.getRemoved());
        colorRepository.saveAndFlush(color);
        return color;
    }

}
