package ru.reksoft.interns.carstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.reksoft.interns.carstore.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long>, JpaSpecificationExecutor<Color> {
    Color findByName (String name);
    Color getById(Integer id);
    void deleteById(Integer id);
}
