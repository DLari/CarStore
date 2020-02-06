package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.EngineDto;
import ru.reksoft.interns.carstore.exceptions.NotValidException;
import ru.reksoft.interns.carstore.service.EngineService;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/engines")
public class EngineControllerAdmin {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EngineService engineService;

    @PostMapping("")
    public EngineDto create(@RequestBody @Valid EngineDto newEngine, BindingResult bindingResult) throws NotValidException {

        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            return engineService.create(newEngine);
        }
    }

    @PutMapping(value = "//{id}")
    public EngineDto update(@PathVariable Integer id, @RequestBody @Valid EngineDto engineDto,
                          BindingResult bindingResult) throws NotValidException {

        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            return engineService.update(id, engineDto);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        engineService.delete(id);
    }
}
