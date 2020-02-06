package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.ModelDto;
import ru.reksoft.interns.carstore.exceptions.NotValidException;
import ru.reksoft.interns.carstore.service.ModelService;

import javax.validation.Valid;


@RestController
@RequestMapping("/admin/models")
public class ModelControllerAdmin {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModelService modelService;
    @PostMapping("")
    public ModelDto create(@RequestBody @Valid ModelDto newModel, BindingResult bindingResult) throws NotValidException {

        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            return modelService.create(newModel);
        }
    }

    @PutMapping(value = "/{id}")
    public ModelDto update(@PathVariable Integer id, @RequestBody @Valid ModelDto modelDto,
                          BindingResult bindingResult) throws NotValidException {

        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            return modelService.update(id, modelDto);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        modelService.delete(id);
    }
}
