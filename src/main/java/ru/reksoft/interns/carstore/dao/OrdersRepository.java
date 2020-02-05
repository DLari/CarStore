package ru.reksoft.interns.carstore.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.reksoft.interns.carstore.entity.Orders;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders getById (Integer id);
    Orders getByUsersId (Integer id);
    List<Orders> getAllByUsersId (Integer id);
    List<Orders> findAll(Sort sort);
}
