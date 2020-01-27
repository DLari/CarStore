package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.DictCarcassDto;
import ru.reksoft.interns.carstore.service.DictCarcassService;

import java.util.List;

@RestController
@RequestMapping("/carcass")
public class DictCarcassController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DictCarcassService dictCarcassService;

    @GetMapping("/{id}")
    public DictCarcassDto getDictCarcass(@PathVariable Integer id) {
        return dictCarcassService.getDictCarcass(id);
    }

    @GetMapping("")
    public List<DictCarcassDto> read(){
        return dictCarcassService.findDictCarcassAll();
    }

}