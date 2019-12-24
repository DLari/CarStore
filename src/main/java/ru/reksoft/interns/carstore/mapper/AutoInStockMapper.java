package ru.reksoft.interns.carstore.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.reksoft.interns.carstore.dao.AutoInStockRepository;
import ru.reksoft.interns.carstore.dao.ColorRepository;
import ru.reksoft.interns.carstore.dao.EngineRepository;
import ru.reksoft.interns.carstore.dao.ModelRepository;
import ru.reksoft.interns.carstore.dto.AutoInStockDto;
import ru.reksoft.interns.carstore.entity.AutoInStock;

import java.util.Objects;

@Component
public class AutoInStockMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private AutoInStockRepository autoInStockRepository;

    public AutoInStock toEntity(AutoInStockDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, AutoInStock.class);
    }

    public AutoInStockDto toDto(AutoInStock entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, AutoInStockDto.class);
    }

    public AutoInStock updateAuto(AutoInStockDto autoInStockDto, AutoInStock autoInStock) {
        autoInStock.setColor(colorRepository.getById(autoInStockDto.getColor().getId()));
        autoInStock.setEngine(engineRepository.getById(autoInStockDto.getEngine().getId()));
        autoInStock.setModel(modelRepository.getById(autoInStockDto.getModel().getId()));
        autoInStock.setPresence(autoInStockDto.getPresence());
        autoInStockRepository.saveAndFlush(autoInStock);
        return autoInStock;
    }

}
