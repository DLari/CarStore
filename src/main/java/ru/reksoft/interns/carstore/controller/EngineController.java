package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.EngineDto;
import ru.reksoft.interns.carstore.exceptions.NotValidException;
import ru.reksoft.interns.carstore.service.EngineService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/engines")
public class EngineController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EngineService engineService;

    @GetMapping("/{id}")
    public EngineDto getDictCarcass(@PathVariable Integer id) {
        return engineService.getEngine(id);
    }


    @GetMapping("")
    public List<EngineDto> read(){
        return engineService.findEngineAll();
    }

    @PostMapping("/admin")
    public EngineDto create(@RequestBody @Valid EngineDto newEngine, BindingResult bindingResult) throws NotValidException {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            return engineService.create(newEngine);
        }
    }
    @PutMapping(value = "/admin//{id}")
    public Integer update(@PathVariable Integer id, @RequestBody @Valid EngineDto engineDto,
                          BindingResult bindingResult) throws NotValidException {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            Integer updateId = engineService.update(id, engineDto);
            return updateId;
        }
    }

    @RequestMapping(value = "/admin/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        engineService.delete(id);
    }
}