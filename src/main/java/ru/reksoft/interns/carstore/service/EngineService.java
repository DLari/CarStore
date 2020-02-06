package ru.reksoft.interns.carstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.dto.EnginesPageDto;
import ru.reksoft.interns.carstore.dto.SelectItemDto;
import ru.reksoft.interns.carstore.mapper.EngineMapper;
import ru.reksoft.interns.carstore.search.SearchSpecifications;
import ru.reksoft.interns.carstore.dao.EngineRepository;
import ru.reksoft.interns.carstore.dto.EngineDto;
import ru.reksoft.interns.carstore.entity.Engine;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private EngineMapper engineMapper;

    @Autowired
    private EngineService engineService;

    public EngineDto getEngine(Integer id) {
        return engineMapper.toDto(engineRepository.getById(id));
    }

    public List<EngineDto> findEngineAll() {
        return engineRepository.findAll(SearchSpecifications.findAllNotRemovedEngine()).stream().map(engineMapper::toDto).collect(Collectors.toList());
    }


    public EnginesPageDto findEngineForFilter() {
        List<SelectItemDto> engines = engineService.findEngineAll().stream().map(engineMapper::toSelectItemDto).collect(Collectors.toList());
        return new EnginesPageDto(){{
            engines = engines;
        }};
    }

    public EngineDto create(EngineDto newEngine) {

       Engine engine= engineRepository.saveAndFlush(engineMapper.toEntity(newEngine));
       EngineDto engineDto=engineMapper.toDto(engine);
        return engineDto;
    }

    public EngineDto update(Integer id, EngineDto engineDto) {

        Engine engine= engineRepository.getById(id);
        engineMapper.updateEngine(engineDto,engine);
        return engineDto;
    }

    public void delete(Integer id) {

        Engine engine= engineRepository.getById(id);
        engine.setRemoved(true);
        engineRepository.saveAndFlush(engine);
    }
}
