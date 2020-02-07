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
    public List<OrdersDto> getListOrders() {
        return ordersService.getListOrders();
    }

    @GetMapping("/mineDelivered")
    public List<OrdersDto> getListOrders2() {
        return ordersService.getListOrders2();
    }

    @GetMapping("/mineBasket")
    public List<OrdersDto> getListOrders3() {
        return ordersService.getListOrders3();
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

        @RequestMapping(value = "/{idUser}/{autoId}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer idUser,@PathVariable Integer autoId) {
        ordersService.deleteOrder( idUser,  autoId);
        }

    @RequestMapping(value = "/paid/{idUser}",method = RequestMethod.PUT)
    public void  toPaid(@PathVariable Integer idUser)  {
         ordersService.toPaid(idUser);
    }

    @RequestMapping(value = "/updateDateOfPayment/{idUser}",method = RequestMethod.PUT)
    public void  updateDateOfPayment(@PathVariable Integer idUser)  {
        ordersService.updateDateOfPayment(idUser);
    }

//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
//    public void delete(@PathVariable Integer id) {
//        ordersService.toCanceled(id);
//    }

//    @PutMapping(value = "/canceled")
//    public OrdersDto  toCanceled()  {
//       return ordersService.toCanceled();
//    }
//
//    @PutMapping(value = "/confirmed")
//    public OrdersDto  toConfirmed()  {
//        return ordersService.toConfirmed();
//    }
//
}
