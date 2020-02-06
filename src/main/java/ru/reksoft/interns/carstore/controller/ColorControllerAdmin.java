package ru.reksoft.interns.carstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.ColorDTO;
import ru.reksoft.interns.carstore.exceptions.NotValidException;
import ru.reksoft.interns.carstore.service.ColorService;

import javax.validation.Valid;

@RestController
@RequestMapping("admin/colors")
public class ColorControllerAdmin {

    @Autowired
    private ColorService colorService;

    @PostMapping("")
    public ColorDTO create(@RequestBody @Valid ColorDTO newColor, BindingResult bindingResult) throws NotValidException {

        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            return colorService.create(newColor);
        }
    }

    @PutMapping(value = "/{id}")
    public ColorDTO update(@PathVariable Integer id, @RequestBody @Valid ColorDTO colorDto,
                          BindingResult bindingResult) throws NotValidException {

        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
           return colorService.update(id, colorDto);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        colorService.delete(id);
    }

}
