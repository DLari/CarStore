package ru.reksoft.interns.carstore.service;

import liquibase.pro.packaged.D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.reksoft.interns.carstore.dao.AutoInStockRepository;
import ru.reksoft.interns.carstore.dao.DictOrderStatusRepository;
import ru.reksoft.interns.carstore.dao.UsersRepository;
import ru.reksoft.interns.carstore.dto.AutoInStockDto;
import ru.reksoft.interns.carstore.dto.ColorDTO;
import ru.reksoft.interns.carstore.dto.UsersDto;
import ru.reksoft.interns.carstore.entity.AutoInStock;
import ru.reksoft.interns.carstore.entity.Orders;
import ru.reksoft.interns.carstore.mapper.AutoInStockMapper;
import ru.reksoft.interns.carstore.mapper.DictOrderStatusMapper;
import ru.reksoft.interns.carstore.mapper.OrdersMapper;
import ru.reksoft.interns.carstore.dao.OrdersRepository;
import ru.reksoft.interns.carstore.dto.OrdersDto;
import ru.reksoft.interns.carstore.mapper.UsersMapper;
import ru.reksoft.interns.carstore.search.SearchSpecifications;

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

    @Autowired
    private DictOrderStatusRepository dictOrderStatusRepository;

    @Autowired
    private DictOrderStatusMapper dictOrderStatusMapper;

//    public OrdersDto getUser(Integer id) {
//        return ordersMapper.toDto(ordersRepository.getById(id));
//    }

public List<OrdersDto> getListOrders() {

    UsersDto usersDto = usersMapper.toDto(usersRepository.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
    Integer idUser = usersDto.getId();
    return ordersRepository.getAllByUsersId(idUser).stream().map(ordersMapper::toDto).collect(Collectors.toList());
}



    public List<OrdersDto> getListOrders2() {

        UsersDto usersDto = usersMapper.toDto(usersRepository.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
        Integer idUser = usersDto.getId();
        return ordersRepository.findAll(SearchSpecifications.findAllDeliveredOrders().and(SearchSpecifications.findOrdersById(idUser)))
                .stream().map(ordersMapper::toDto).collect(Collectors.toList());
    }

    public List<OrdersDto> getListOrders3() {

        UsersDto usersDto = usersMapper.toDto(usersRepository.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
        Integer idUser = usersDto.getId();
        return ordersRepository.findAll(SearchSpecifications.findAllNotDeliveredOrders().and(SearchSpecifications.findOrdersById(idUser)))
                .stream().map(ordersMapper::toDto).collect(Collectors.toList());
    }

//    public OrdersDto getOrder() {
//
//        UsersDto usersDto = usersMapper.toDto(usersRepository.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
//        Integer idUser = usersDto.getId();
//        return ordersMapper.toDto(ordersRepository.getByUsersId(idUser));
//    }
    public List<OrdersDto> getOrderNew(Integer id) {

        UsersDto usersDto = usersMapper.toDto(usersRepository.getByLogin(usersRepository.getById(id).getLogin()));
        Integer idUser = usersDto.getId();
        return ordersRepository.getByUsersId(idUser).stream().map(ordersMapper::toDto).collect(Collectors.toList());
    }

    public List<OrdersDto> findOrders() {
        return ordersRepository.findAll().stream().map(ordersMapper::toDto).collect(Collectors.toList());
    }

    public List<OrdersDto> findOrders2() {
        return ordersRepository.findAll(Sort.by("date")).stream().map(ordersMapper::toDto).collect(Collectors.toList());
    }

    public OrdersDto create(OrdersDto newOrder) {

        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        Integer id=newOrder.getId();
        newOrder.setOrderNumber(Integer.toString(100+generateTrackNumber()));
        newOrder.setUsers(usersMapper.toDto(usersRepository.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName())));
        newOrder.setDate(date);
        newOrder.setDictOrderStatus(dictOrderStatusMapper.toDto(dictOrderStatusRepository.getById(1)));
        newOrder.setPrice(autoInStockMapper.toDto(autoInStockRepository.getById(newOrder.getAutoInStock().getId())).getPrice());
        Orders orders= ordersRepository.saveAndFlush(ordersMapper.toEntity(newOrder));
        OrdersDto ordersDto=ordersMapper.toDto(orders);
        return ordersDto;
    }
    public Integer generateTrackNumber () {

        int min = 100;
        int diff = 10_000;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

    public OrdersDto update(Integer id, OrdersDto ordersDto) {

        Orders orders= ordersRepository.getById(id);
        ordersMapper.updateMapper(ordersDto,orders);
        return ordersDto;
    }

    public void deleteOrder (Integer idUser, Integer autoId) {

        List<OrdersDto> ordersDtoList = getOrderNew(idUser);
        OrdersDto ordersDto = null;
        for (OrdersDto item: ordersDtoList) {
            if (item.getAutoInStock().getId() == autoId) {
                ordersDto = item;
            }
        }
        ordersRepository.delete(ordersMapper.toEntity(ordersDto));
    }

//    public OrdersDto toCanceled() {
//         OrdersDto ordersDto = getOrder();
//         ordersDto.setDictOrderStatus(dictOrderStatusMapper.toDto(dictOrderStatusRepository.getById(5)));
//        ordersRepository.saveAndFlush(ordersMapper.toEntity(ordersDto));
//        return ordersDto;
//    }
//
//    public OrdersDto toConfirmed() {
//        OrdersDto ordersDto = getOrder();
//        ordersDto.setDictOrderStatus(dictOrderStatusMapper.toDto(dictOrderStatusRepository.getById(2)));
//        ordersRepository.saveAndFlush(ordersMapper.toEntity(ordersDto));
//        return ordersDto;
//    }
//
    public void toPaid(Integer id) {

        List<OrdersDto> ordersDtoList = getOrderNew(id);
        for (OrdersDto item: ordersDtoList) {
            if (item.getDictOrderStatus().getId() == 1) {
                item.setDictOrderStatus(dictOrderStatusMapper.toDto(dictOrderStatusRepository.getById(3)));
                ordersRepository.saveAndFlush(ordersMapper.toEntity(item));
            }
        }
    }

    public OrdersDto toDelivered(Integer id, Integer autoId) {

        List<OrdersDto> ordersDtoList = getOrderNew(id);
        OrdersDto ordersDto = null;
        for (OrdersDto item: ordersDtoList) {
            if (item.getId() == autoId) {
                ordersDto = item;
            }
        }
        ordersDto.setDictOrderStatus(dictOrderStatusMapper.toDto(dictOrderStatusRepository.getById(4)));
        ordersRepository.saveAndFlush(ordersMapper.toEntity(ordersDto));
        return ordersDto;
    }
}
