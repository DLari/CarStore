package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.AutoInStockDto;
import ru.reksoft.interns.carstore.dto.CarsFiltersDto;
import ru.reksoft.interns.carstore.dto.PageDto;
import ru.reksoft.interns.carstore.service.AutoInStockService;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class AutoInStockController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AutoInStockService autoInStockService;

    @GetMapping("/{id}")
    public AutoInStockDto getAuto(@PathVariable Integer id) {
        return autoInStockService.getAuto(id);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public CarsPageDTO read() {
//        return autoInStockService.findAuto();
//    }

    @RequestMapping(method = RequestMethod.GET,value = "getFilters")
    @ResponseBody
    public CarsFiltersDto getFilters() {
        return autoInStockService.getFilters();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ResponseBody
    public List<AutoInStockDto> findAll() {
        return autoInStockService.findAutoAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "search")
    @ResponseBody
    public PageDto<AutoInStockDto> searchCars(

            @RequestParam (name = "takeSize") Integer size,
            @RequestParam( name = "takeNumber") Integer number,
            @RequestParam(name = "model", required = false) Integer modelId,
            @RequestParam (name = "color", required = false) Integer colorId,
            @RequestParam  (name = "carcass", required = false) Integer carcassId,
            @RequestParam  (name = "engine", required = false) Integer engineId
            ) {
        return autoInStockService.search(modelId,colorId,carcassId,engineId,size,number);
    }

}