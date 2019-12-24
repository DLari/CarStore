package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.ColorDTO;
import ru.reksoft.interns.carstore.exceptions.NotValidException;
import ru.reksoft.interns.carstore.service.ColorService;

import javax.validation.Valid;
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
//        LOGGER.trace("This is TRACE");
//        LOGGER.debug("This is DEBUG");
        LOGGER.info( "getById");
//        LOGGER.warn("This is WARN");
//        LOGGER.error("This is ERROR");
        ColorDTO color = colorService.getById(id);
        return color;
    }

    @GetMapping("")
    @ResponseBody
    public List<ColorDTO> read(){
//        if(id==0)
//            throw new IdNotFoundException();
      return colorService.findColorAll();
    }


    @PostMapping("")
    public ColorDTO create(@RequestBody @Valid  ColorDTO newColor, BindingResult bindingResult) throws NotValidException {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
          throw new NotValidException(bindingResult);
        }
        else {
            return colorService.create(newColor);
        }
    }




    @PutMapping(value = "/{id}")
    public Integer update(@PathVariable Integer id, @RequestBody ColorDTO colorDto) {
        Integer updateId= colorService.update(id, colorDto);
        return updateId;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        colorService.delete(id);
    }
}