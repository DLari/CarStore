package ru.reksoft.interns.carstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.entity.Orders;
import ru.reksoft.interns.carstore.mapper.OrdersMapper;
import ru.reksoft.interns.carstore.dao.OrdersRepository;
import ru.reksoft.interns.carstore.dto.OrdersDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrdersMapper ordersMapper;

    public OrdersDto getUser(Integer id) {
        return ordersMapper.toDto(ordersRepository.getById(id));
    }

    public List<OrdersDto> findUsers() {
        return ordersRepository.findAll().stream().map(ordersMapper::toDto).collect(Collectors.toList());
    }

    public Integer create(OrdersDto newOrder) {
        Integer id=newOrder.getId();
        ordersRepository.saveAndFlush(ordersMapper.toEntity(newOrder));
        return id;
    }

    public Integer update(Integer id, OrdersDto ordersDto) {
        Integer reternId=id;
        Orders orders= ordersRepository.getById(id);
        ordersMapper.updateMapper(ordersDto,orders);
        return reternId;
    }

    public void delete(Integer id) {
        Orders orders=ordersRepository.getById(id);
        orders.getDictOrderStatus().setName("in the process");
        ordersRepository.saveAndFlush(orders);
    }
}
