package ru.reksoft.interns.carstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.dto.OrdersDto;
import ru.reksoft.interns.carstore.service.OrdersService;

import java.util.List;

@RestController
@RequestMapping("/admin/orders")
public class OrdersControllerAdmin {

    @Autowired
    private OrdersService ordersService;
    @GetMapping("")
    public List<OrdersDto> read(){

        return ordersService.findOrders2();
    }

    @PutMapping(value = "/delivered/{id}/{autoId}")
    public OrdersDto toDelivered  (@PathVariable Integer id, @PathVariable Integer autoId)  {
        return ordersService.toDelivered(id, autoId);
    }

//    @RequestMapping(value = "/delivered}",method = RequestMethod.GET)
//    public void getDeliveredOrders() {
//        ordersService.getDeliveredOrders();
//    }

}
