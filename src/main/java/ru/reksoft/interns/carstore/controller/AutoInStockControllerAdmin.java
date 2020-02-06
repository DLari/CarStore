package ru.reksoft.interns.carstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.AutoInStockDto;
import ru.reksoft.interns.carstore.exceptions.NotValidException;
import ru.reksoft.interns.carstore.service.AutoInStockService;
import javax.validation.Valid;

@RestController
@RequestMapping("/admin/cars")
public class AutoInStockControllerAdmin {

    @Autowired
    private AutoInStockService autoInStockService;

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
    public AutoInStockDto update(@PathVariable Integer id, @RequestBody @Valid AutoInStockDto autoInStockDto,
                          BindingResult bindingResult) throws NotValidException {

        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            return autoInStockService.update(id, autoInStockDto);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        autoInStockService.delete(id);
    }
}
