package ru.reksoft.interns.carstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.reksoft.interns.carstore.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users getById (Integer id);
}
