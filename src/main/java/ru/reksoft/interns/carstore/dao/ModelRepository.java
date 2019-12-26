package ru.reksoft.interns.carstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.reksoft.interns.carstore.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long>,JpaSpecificationExecutor<Model> {
    Model getById (Integer id);
}
