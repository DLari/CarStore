package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.AutoInStockDto;
import ru.reksoft.interns.carstore.dto.PageDto;
import ru.reksoft.interns.carstore.entity.AutoInStock;
import ru.reksoft.interns.carstore.exceptions.NotValidException;
import ru.reksoft.interns.carstore.service.AutoInStockService;

import javax.validation.Valid;

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


    @GetMapping("")
    public PageDto<AutoInStockDto> read( @RequestParam (name = "size") Integer size,

                                      @RequestParam( name = "number") Integer number ){
//        if(id==0)
//            throw new IdNotFoundException();
        return autoInStockService.findAutoAll(size,number);
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

    @PostMapping("")
    public AutoInStockDto create(@RequestBody @Valid AutoInStockDto newAuto, BindingResult bindingResult) throws NotValidException {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
       return autoInStockService.create(newAuto);
        }
    }

    @PutMapping(value = "/{id}")
    public Integer update(@PathVariable Integer id, @RequestBody AutoInStockDto autoInStockDto) {
        Integer updateId= autoInStockService.update(id, autoInStockDto);
        return updateId;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        autoInStockService.delete(id);
    }
}