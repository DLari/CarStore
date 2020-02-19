package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.ColorDto;
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
    public ColorDto getById(@PathVariable("id")  Integer id){
        LOGGER.info( "getById");
        ColorDto color = colorService.getById(id);
        return color;
    }

    @GetMapping("")
    @ResponseBody
    public List<ColorDto> read(){
      return colorService.findColorAll();
    }

    @GetMapping("/forFilter")
    public ColorsPageDto readFilter(){
        return colorService.findColorForFilter();
    }

    public void setColorService(ColorService colorService) {
        this.colorService = colorService;
    }

}