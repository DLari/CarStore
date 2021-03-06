package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.ModelDto;
import ru.reksoft.interns.carstore.dto.ModelsPageDto;
import ru.reksoft.interns.carstore.service.ModelService;
import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModelService modelService;

    @GetMapping("/{id}")
    public ModelDto getDictCarcass(@PathVariable Integer id) {
        return modelService.getModel(id);
    }


    @GetMapping("")
    public List<ModelDto> read(){
        return modelService.findModelAll();
    }

    @GetMapping("/forFilter")
    public ModelsPageDto readFilter(){
        return modelService.findModelforFilter();
    }

}