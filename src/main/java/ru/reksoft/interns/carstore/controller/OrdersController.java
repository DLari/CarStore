package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.OrdersDto;
import ru.reksoft.interns.carstore.exceptions.NotValidException;
import ru.reksoft.interns.carstore.service.OrdersService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/{id}")
    public OrdersDto getDictCarcass(@PathVariable Integer id) {
        return ordersService.getUser(id);
    }


    @GetMapping("")
    public List<OrdersDto> read(){

        return ordersService.findUsers();
    }

    @PostMapping("")
    public Integer create(@RequestBody @Valid OrdersDto newOrder, BindingResult bindingResult) throws NotValidException {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            Integer id = ordersService.create(newOrder);
            return id;
        }
    }
    @PutMapping(value = "/{id}")
    public Integer update(@PathVariable Integer id, @RequestBody @Valid OrdersDto ordersDto,
                          BindingResult bindingResult) throws NotValidException {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            Integer updateId = ordersService.update(id, ordersDto);
            return updateId;
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        ordersService.delete(id);
    }
}
