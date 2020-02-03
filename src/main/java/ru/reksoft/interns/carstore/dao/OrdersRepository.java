package ru.reksoft.interns.carstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.reksoft.interns.carstore.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders getById (Integer id);
    Orders getByUsersId (Integer id);
}
