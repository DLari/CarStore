package ru.reksoft.interns.carstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.reksoft.interns.carstore.entity.Engine;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long>, JpaSpecificationExecutor<Engine> {
    Engine getById (Integer id);
}
