package ru.reksoft.interns.carstore.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.reksoft.interns.carstore.dao.AutoInStockRepository;
import ru.reksoft.interns.carstore.dao.DictOrderStatusRepository;
import ru.reksoft.interns.carstore.dao.OrdersRepository;
import ru.reksoft.interns.carstore.dao.UsersRepository;
import ru.reksoft.interns.carstore.dto.OrdersDto;
import ru.reksoft.interns.carstore.dto.UsersDto;
import ru.reksoft.interns.carstore.entity.Orders;
import ru.reksoft.interns.carstore.entity.Users;

import java.util.Objects;

@Component
public class OrdersMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AutoInStockRepository autoInStockRepository;

    @Autowired
    private DictOrderStatusRepository dictOrderStatusRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    public Orders toEntity(OrdersDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Orders.class);
    }

    public OrdersDto toDto(Orders entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, OrdersDto.class);
    }

    public Orders updateMapper (OrdersDto ordersDto, Orders orders) {
        orders.setAutoInStock(autoInStockRepository.getById(orders.getAutoInStock().getId()));
        orders.setDate(ordersDto.getDate());
        orders.setDictOrderStatus(dictOrderStatusRepository.getById(orders.getDictOrderStatus().getId()));
        orders.setId(ordersDto.getId());
        orders.setPrice(ordersDto.getPrice());
        orders.setUsers(usersRepository.getById(orders.getUsers().getId()));
        return orders;

    }

}
