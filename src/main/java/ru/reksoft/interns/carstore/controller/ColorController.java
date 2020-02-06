package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.ColorDTO;
import ru.reksoft.interns.carstore.dto.ColorsPageDto;
import ru.reksoft.interns.carstore.service.ColorService;
import java.util.List;

@RestController
@RequestMapping("/colors")
public final class ColorController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ColorController.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ColorService colorService;

    @GetMapping("/{id}")
    @ResponseBody
    public ColorDTO getById(@PathVariable("id")  Integer id){
        LOGGER.info( "getById");
        ColorDTO color = colorService.getById(id);
        return color;
    }

    @GetMapping("")
    @ResponseBody
    public List<ColorDTO> read(){
      return colorService.findColorAll();
    }

    @GetMapping("/forFilter")
    public ColorsPageDto readFilter(){
        return colorService.findColorForFilter();
    }
}