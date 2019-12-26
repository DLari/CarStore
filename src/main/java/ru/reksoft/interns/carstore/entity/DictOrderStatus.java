package ru.reksoft.interns.carstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * статус заказа
 */
@Entity
@Table(name="dict_order_status")
public class DictOrderStatus {

    /**
     * id
     */
    @Id
   @Column(name = "id")
    private Integer id;

    /**
     * название статуса
     */
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

