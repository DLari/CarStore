package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.EngineDto;
import ru.reksoft.interns.carstore.dto.EnginesPageDto;
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

    @GetMapping("/forFilter")
    public EnginesPageDto readFilter(){
        return engineService.findEngineForFilter();
    }

}