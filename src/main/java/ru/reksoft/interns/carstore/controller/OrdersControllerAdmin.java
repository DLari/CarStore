package ru.reksoft.interns.carstore.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.reksoft.interns.carstore.dto.OrdersDto;
import ru.reksoft.interns.carstore.service.OrdersService;

import java.util.List;

@RestController
@RequestMapping("/admin/orders")
public class OrdersControllerAdmin {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrdersService ordersService;
    @GetMapping("")
    public List<OrdersDto> read(){

        return ordersService.findUsers();
    }
}
