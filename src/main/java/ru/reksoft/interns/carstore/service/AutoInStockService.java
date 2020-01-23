package ru.reksoft.interns.carstore.service;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.dao.ColorRepository;
import ru.reksoft.interns.carstore.dao.EngineRepository;
import ru.reksoft.interns.carstore.dao.ModelRepository;
import ru.reksoft.interns.carstore.dto.CarsPageDTO;
import ru.reksoft.interns.carstore.dto.PageDto;
import ru.reksoft.interns.carstore.dto.SelectItemDto;
import ru.reksoft.interns.carstore.entity.AutoInStock;
import ru.reksoft.interns.carstore.entity.Color;
import ru.reksoft.interns.carstore.mapper.*;
import ru.reksoft.interns.carstore.search.SearchSpecifications;
import ru.reksoft.interns.carstore.dao.AutoInStockRepository;
import ru.reksoft.interns.carstore.dto.AutoInStockDto;


import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class AutoInStockService {

    @Autowired
    private AutoInStockRepository autoInStockRepository;

    @Autowired
    private AutoInStockMapper autoInStockMapper;

    @Autowired
    private ModelService modelService;

    @Autowired
    private EngineService engineService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private DictCarcassService dictCarcassService;

    @Autowired
    private ModelMapperr modelMapperr;

    @Autowired
    private EngineMapper engineMapper;

    @Autowired
    private ColorMapper colorMapper;

    @Autowired
    private DictCarcassMapper dictCarcassMapper;

    public AutoInStockDto getAuto(Integer id) {

        return autoInStockMapper.toDto(autoInStockRepository.getById(id));
    }

    public CarsPageDTO findAutoAll() {
        List<SelectItemDto> engines = engineService.findEngineAll().stream().map(engineMapper::toSelectItemDto).collect(Collectors.toList());
        List<SelectItemDto> models = modelService.findModelAll().stream().map(modelMapperr::toSelectItemDto).collect(Collectors.toList());
        List<SelectItemDto> colors = colorService.findColorAll().stream().map(colorMapper::toSelectItemDto).collect(Collectors.toList());
        List<SelectItemDto> carcass = dictCarcassService.findDictCarcassAll().stream().map(dictCarcassMapper::toSelectItemDto).collect(Collectors.toList());
        List<AutoInStockDto>  cars = autoInStockRepository.findAll().stream().map(autoInStockMapper::toDto).collect(Collectors.toList());
        return new CarsPageDTO(){{
            Engines = engines;
            Models = models;
            Autos = cars;
            Colors = colors;
            Carcass = carcass;
        }};
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
//        BigDecimal priceColor = colorRepository.getById(newAuto.getColor().getId()).getPrice();
//        BigDecimal priceEngine = engineRepository.getById(newAuto.getEngine().getId()).getPrice();
//        BigDecimal priceModel = modelRepository.getById(newAuto.getModel().getId()).getPrice();
//        newAuto.setPrice(priceColor.add(priceEngine).add(priceModel));
       AutoInStock autoInStockReturn = autoInStockRepository.saveAndFlush(autoInStockMapper.toEntity(newAuto));
       AutoInStockDto autoInStockDto = autoInStockMapper.toDto(autoInStockReturn);
        return autoInStockDto;
    }

    public AutoInStockDto update(Integer id, AutoInStockDto autoInStockDto) {
        AutoInStock autoInStock = autoInStockRepository.getById(id);
        autoInStockMapper.updateAuto(autoInStockDto, autoInStock);
        return autoInStockDto;
    }

    public void delete(Integer id) {
        AutoInStock autoInStock = autoInStockRepository.getById(id);
        autoInStock.setPresence(autoInStock.getPresence() - 1);
        autoInStockRepository.saveAndFlush(autoInStock);
    }

}
