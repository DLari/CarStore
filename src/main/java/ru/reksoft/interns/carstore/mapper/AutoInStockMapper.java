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

import java.math.BigDecimal;
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

    @Autowired
    private EngineMapper engineMapper;
    @Autowired
    private ModelMapperr modelMapperr;
    @Autowired
    private ColorMapper colorMapper;
    public AutoInStockDto toDto(AutoInStock entity) {
        BigDecimal priceColor = colorRepository.getById(entity.getColor().getId()).getPrice();
        BigDecimal priceEngine = engineRepository.getById(entity.getEngine().getId()).getPrice();
        BigDecimal priceModel = modelRepository.getById(entity.getModel().getId()).getPrice();
        BigDecimal totalPrice = priceColor.add(priceEngine).add(priceModel);
        return new AutoInStockDto(
                entity.getId(),
                engineMapper.toDto(entity.getEngine()),
                modelMapperr.toDto( entity.getModel()),
                colorMapper.toDto(entity.getColor()),
                entity.getPresence(),
                totalPrice
        );
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
