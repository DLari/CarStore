package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.ModelDto;
import ru.reksoft.interns.carstore.exceptions.NotValidException;
import ru.reksoft.interns.carstore.service.ModelService;

import javax.validation.Valid;
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
//        if(id==0)
//            throw new IdNotFoundException();
        return modelService.findModelAll();
    }
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
    public Integer update(@PathVariable Integer id, @RequestBody ModelDto modelDto) {
        Integer updateId= modelService.update(id, modelDto);
        return updateId;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        modelService.delete(id);
    }
}