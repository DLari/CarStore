package ru.reksoft.interns.carstore.service;

import liquibase.pro.packaged.D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.dao.AutoInStockRepository;
import ru.reksoft.interns.carstore.dao.UsersRepository;
import ru.reksoft.interns.carstore.dto.AutoInStockDto;
import ru.reksoft.interns.carstore.dto.ColorDTO;
import ru.reksoft.interns.carstore.entity.AutoInStock;
import ru.reksoft.interns.carstore.entity.Orders;
import ru.reksoft.interns.carstore.mapper.AutoInStockMapper;
import ru.reksoft.interns.carstore.mapper.OrdersMapper;
import ru.reksoft.interns.carstore.dao.OrdersRepository;
import ru.reksoft.interns.carstore.dto.OrdersDto;
import ru.reksoft.interns.carstore.mapper.UsersMapper;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AutoInStockRepository autoInStockRepository;

    @Autowired
    private AutoInStockMapper autoInStockMapper;

    public OrdersDto getUser(Integer id) {
        return ordersMapper.toDto(ordersRepository.getById(id));
    }

    public List<OrdersDto> findUsers() {
        return ordersRepository.findAll().stream().map(ordersMapper::toDto).collect(Collectors.toList());
    }

    public OrdersDto create(OrdersDto newOrder) {

        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        int min=100;
        int diff = 10_000;
        Random random = new Random();
        int i = random.nextInt(diff+1);
        i+=min;
        Integer id=newOrder.getId();
        newOrder.setOrderNumber(Integer.toString(100+i));
        newOrder.setUsers(usersMapper.toDto(usersRepository.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName())));
        newOrder.setDate(date);
      //  newOrder.getDictOrderStatus().setId(1);

        newOrder.setPrice(autoInStockMapper.toDto(autoInStockRepository.getById(newOrder.getAutoInStock().getId())).getPrice());
        Orders orders= ordersRepository.saveAndFlush(ordersMapper.toEntity(newOrder));
        OrdersDto ordersDto=ordersMapper.toDto(orders);
        return ordersDto;
    }

    public OrdersDto update(Integer id, OrdersDto ordersDto) {

        Orders orders= ordersRepository.getById(id);
        ordersMapper.updateMapper(ordersDto,orders);
        return ordersDto;
    }

    public void toCanceled(Integer id) {
        Orders orders=ordersRepository.getById(id);
        orders.getDictOrderStatus().setId(5);
        ordersRepository.saveAndFlush(orders);
    }

    public void toConfirmed(Integer id) {
        Orders orders=ordersRepository.getById(id);
        orders.getDictOrderStatus().setId(2);
        ordersRepository.saveAndFlush(orders);
    }

    public void toPaid(Integer id) {
        Orders orders=ordersRepository.getById(id);
        orders.getDictOrderStatus().setId(3);
        ordersRepository.saveAndFlush(orders);
    }

    public void toDelivered(Integer id) {
        Orders orders=ordersRepository.getById(id);
        orders.getDictOrderStatus().setId(4);
        ordersRepository.saveAndFlush(orders);
    }
}
