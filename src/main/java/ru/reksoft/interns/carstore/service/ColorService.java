package ru.reksoft.interns.carstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.dto.ColorsPageDto;
import ru.reksoft.interns.carstore.dto.SelectItemDto;
import ru.reksoft.interns.carstore.mapper.ColorMapper;
import ru.reksoft.interns.carstore.search.SearchSpecifications;
import ru.reksoft.interns.carstore.dao.ColorRepository;
import ru.reksoft.interns.carstore.dto.ColorDto;
import ru.reksoft.interns.carstore.entity.Color;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private ColorMapper colorMapper;

    public ColorDto getById(Integer id) {
        return colorMapper.toDto(colorRepository.getById(id));
    }

    public List<ColorDto> findColorAll() {
        return colorRepository.findAll(
                SearchSpecifications.findAllNotRemovedColor()
        ).stream().map(colorMapper::toDto).collect(Collectors.toList());
    }

    public ColorsPageDto findColorForFilter() {
        List<SelectItemDto> colors = findColorAll().stream().map(colorMapper::toSelectItemDto).collect(Collectors.toList());
        return new ColorsPageDto(){{
            Colors = colors;
        }};
    }

    public ColorDto create(ColorDto newColor) {
      Color color =  colorRepository.saveAndFlush(colorMapper.toEntity(newColor));
      ColorDto colorDTO= colorMapper.toDto(color);
        return colorDTO;
    }

    public ColorDto update(Integer id, ColorDto colorDTO) {

        //Color color = colorRepository.getById(id);
       colorRepository.saveAndFlush( colorMapper.updateMapper(colorDTO, colorRepository.getById(id)));
        return colorDTO;
    }

    public Integer delete(Integer id) {

        Integer reternId=id;
        Color color = colorRepository.getById(id);
        color.setRemoved(true);
        colorRepository.saveAndFlush(color);
        return reternId;
    }

    public void setColorMapper(ColorMapper colorMapper) {
        this.colorMapper = colorMapper;
    }
}
