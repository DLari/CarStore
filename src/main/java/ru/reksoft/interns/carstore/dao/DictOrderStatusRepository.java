package ru.reksoft.interns.carstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.reksoft.interns.carstore.entity.DictOrderStatus;

@Repository
public interface DictOrderStatusRepository  extends JpaRepository<DictOrderStatus, Long> {
    DictOrderStatus getById (Integer id);
}
