package ru.reksoft.interns.carstore.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name="dict_order_status")
public class DictOrderStatus {

  /*  @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;*/

 /*   @OneToMany(mappedBy = "dict_order_status")
    private List<Orders> orders;*/

    @Id
    //@GeneratedValue
   @Column(name = "id")
    private Integer id;

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

