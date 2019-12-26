package ru.reksoft.interns.carstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.dto.PageDto;
import ru.reksoft.interns.carstore.entity.AutoInStock;
import ru.reksoft.interns.carstore.mapper.AutoInStockMapper;
import ru.reksoft.interns.carstore.search.SearchSpecifications;
import ru.reksoft.interns.carstore.dao.AutoInStockRepository;
import ru.reksoft.interns.carstore.dto.AutoInStockDto;


import java.util.List;

import java.util.stream.Collectors;

@Service
public class AutoInStockService {

    @Autowired
    private AutoInStockRepository autoInStockRepository;

    @Autowired
    private AutoInStockMapper autoInStockMapper;

    public AutoInStockDto getAuto(Integer id) {

        return autoInStockMapper.toDto(autoInStockRepository.getById(id));
    }

    public PageDto<AutoInStockDto> search(Integer modelId, Integer colorId, Integer carcassId,
                                          Integer engineId, int pageSize, int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<AutoInStock> autoInStockPage = autoInStockRepository.findAll(SearchSpecifications.findModelId(modelId)
                        .and(SearchSpecifications.findColorId(colorId))
                        .and(SearchSpecifications.findCarcassId(carcassId))
                        .and(SearchSpecifications.findEngineId(engineId))
                , pageable);

        List<AutoInStock> autoInStockList = autoInStockPage.getContent();
        List<AutoInStockDto> autoInStockDtoList = autoInStockList.stream().map(autoInStockMapper::toDto).collect(Collectors.toList());
        PageDto<AutoInStockDto> pageDto = new PageDto<>(autoInStockPage, autoInStockDtoList);
        return pageDto;
    }


    public AutoInStockDto create(AutoInStockDto newAuto) {
        autoInStockRepository.saveAndFlush(autoInStockMapper.toEntity(newAuto));
        return newAuto;
    }

    public Integer update(Integer id, AutoInStockDto autoInStockDto) {
        Integer reternId = id;
        AutoInStock autoInStock = autoInStockRepository.getById(id);
        autoInStockMapper.updateAuto(autoInStockDto, autoInStock);
        return reternId;
    }

    public void delete(Integer id) {
        AutoInStock autoInStock = autoInStockRepository.getById(id);
        autoInStock.setPresence(autoInStock.getPresence() - 1);
        autoInStockRepository.saveAndFlush(autoInStock);
    }

}
