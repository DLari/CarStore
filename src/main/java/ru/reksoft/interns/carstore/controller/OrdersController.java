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

//    @GetMapping("/{id}")
//    public OrdersDto getDictCarcass(@PathVariable Integer id) {
//        return ordersService.getUser(id);
//    }

    @GetMapping("/mine")
    public OrdersDto getOrder() {
        return ordersService.getOrder();
    }


    @PostMapping("")
    public OrdersDto create(@RequestBody @Valid OrdersDto newOrder, BindingResult bindingResult) throws NotValidException {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
           return ordersService.create(newOrder);
        }
    }
    @PutMapping(value = "/{id}")
    public OrdersDto update(@PathVariable Integer id, @RequestBody @Valid OrdersDto ordersDto,
                          BindingResult bindingResult) throws NotValidException {
        bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            throw new NotValidException(bindingResult);
        }
        else {
            return ordersService.update(id, ordersDto);
        }
    }

//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
//    public void delete(@PathVariable Integer id) {
//        ordersService.toCanceled(id);
//    }

    @PutMapping(value = "/canceled")
    public OrdersDto  toCanceled()  {
       return ordersService.toCanceled();
    }

    @PutMapping(value = "/confirmed")
    public OrdersDto  toConfirmed()  {
        return ordersService.toConfirmed();
    }

    @PutMapping(value = "/paid")
    public OrdersDto  toPaid()  {
        return ordersService.toPaid();
    }

    @PutMapping(value = "/delivered")
    public OrdersDto  toDelivered()  {
        return ordersService.toDelivered();
    }
}
