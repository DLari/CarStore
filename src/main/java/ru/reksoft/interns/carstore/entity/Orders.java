package ru.reksoft.interns.carstore.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;



@Setter
@Getter
@Entity
@Table( name="orders")
public class Orders {

    @ManyToOne
    @JoinColumn(name = "auto_in_stock_id")
    private AutoInStock autoInStock;


    @ManyToOne
    @JoinColumn(name = "dict_order_status_id")
    private DictOrderStatus dictOrderStatus;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column( name = "id")
    private Integer id;

    @Column(name = "price")
    private BigDecimal price;

    @Column( name = "date")
    private Date date;

    public AutoInStock getAutoInStock() {
        return autoInStock;
    }

    public void setAutoInStock(AutoInStock autoInStock) {
        this.autoInStock = autoInStock;
    }

    public DictOrderStatus getDictOrderStatus() {
        return dictOrderStatus;
    }

    public void setDictOrderStatus(DictOrderStatus dictOrderStatus) {
        this.dictOrderStatus = dictOrderStatus;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /* client_id
auto_in stock_id*/

}