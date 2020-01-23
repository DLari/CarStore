package ru.reksoft.interns.carstore.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.reksoft.interns.carstore.dao.EngineRepository;
import ru.reksoft.interns.carstore.dao.ModelRepository;
import ru.reksoft.interns.carstore.dto.EngineDto;
import ru.reksoft.interns.carstore.dto.ModelDto;
import ru.reksoft.interns.carstore.dto.SelectItemDto;
import ru.reksoft.interns.carstore.entity.Engine;

import java.util.Objects;

@Component
public class EngineMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private ModelRepository modelRepository ;

    public Engine toEntity(EngineDto dto) {
        return Objects.isNull(dto) ? null :
                modelMapper.map(dto, Engine.class);
    }

    public EngineDto toDto(Engine entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, EngineDto.class);
    }
    public SelectItemDto toSelectItemDto(EngineDto entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, SelectItemDto.class);
    }

    //public <T> T toDto(Engine entity, Class<T> cls) {
       // return Objects.isNull(entity) ? null : modelMapper.map(entity, cls);
    //}

    public Engine updateEngine(EngineDto engineDto, Engine engine) {
        engine.setName(engineDto.getName());
        engine.setPrice(engineDto.getPrice());
        engine.setRemoved(engineDto.getRemoved());
        engine.setFuelConsumption(engineDto.getFuelConsumption());
        engine.setPower(engineDto.getPower());
        engineRepository.saveAndFlush(engine);
        return engine;
    }

}
