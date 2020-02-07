package ru.reksoft.interns.carstore.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


/**
 * заказ
 */
@Entity
@Table( name="orders")
public class Orders {

    /**
     * связь с таблицей авто на складе
     */
    @ManyToOne
    @JoinColumn(name = "auto_in_stock_id")
    private AutoInStock autoInStock;

    /**
     * связь с таблицей статус
     */
    @ManyToOne
    @JoinColumn(name = "dict_order_status_id")
    private DictOrderStatus dictOrderStatus;

    /**
     * связь с таблицей пользователь
     */
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;


    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column( name = "id")
    private Integer id;

    /**
     * сумма заказа
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * номер заказа
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * дата сборки заказа
     */
    @Column( name = "date")
    private Date date;

    /**
     * дата оплаты заказа
     */
    @Column( name = "date_of_payment")
    private Date dateOfPayment;

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

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}