package ru.reksoft.interns.carstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public EngineDto getEngine(Integer id) {
        return engineMapper.toDto(engineRepository.getById(id));
    }

    public List<EngineDto> findEngineAll() {
        return engineRepository.findAll(SearchSpecifications.findAllNotRemovedEngine()).stream().map(engineMapper::toDto).collect(Collectors.toList());
    }

    public EngineDto create(EngineDto newEngine) {
        engineRepository.saveAndFlush(engineMapper.toEntity(newEngine));
        return newEngine;
    }

    public Integer update(Integer id, EngineDto engineDto) {

        Integer reternId = id;
        Engine engine= engineRepository.getById(id);
        engineMapper.updateEngine(engineDto,engine);
        return reternId;
    }

    public void delete(Integer id) {

        Engine engine= engineRepository.getById(id);
        engine.setRemoved(true);
        engineRepository.saveAndFlush(engine);
    }
}
