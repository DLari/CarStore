package ru.reksoft.interns.carstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.mapper.ColorMapper;
import ru.reksoft.interns.carstore.search.SearchSpecifications;
import ru.reksoft.interns.carstore.dao.ColorRepository;
import ru.reksoft.interns.carstore.dto.ColorDTO;
import ru.reksoft.interns.carstore.entity.Color;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private ColorMapper colorMapper;

    public ColorDTO getById(Integer id) {
        return colorMapper.toDto(colorRepository.getById(id));
    }

    public List<ColorDTO> findColorAll() {

        return colorRepository.findAll(
                SearchSpecifications.findAllNotRemovedColor()
        ).stream().map(colorMapper::toDto).collect(Collectors.toList());
    }

    public ColorDTO create(ColorDTO newColor) {

      Color color =  colorRepository.saveAndFlush(colorMapper.toEntity(newColor));
      ColorDTO colorDTO= colorMapper.toDto(color);
        return colorDTO;
    }

    public ColorDTO update(Integer id, ColorDTO colorDTO) {

        Color color = colorRepository.getById(id);
        colorMapper.updateMapper(colorDTO, color);
        return colorDTO;
    }

    public Integer delete(Integer id) {

        Integer reternId=id;
        Color color = colorRepository.getById(id);
        color.setRemoved(true);
        colorRepository.saveAndFlush(color);
        return reternId;
    }
}
