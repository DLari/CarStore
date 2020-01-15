package ru.reksoft.interns.carstore.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * пользователи
 */
@Entity
@Table(name="users")
public class Users {

    /**
     * связь с таблицей заказ
     */
    @OneToMany(mappedBy = "users")
    private List<Orders> orders;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * фио
     */
    @Column(name = "fio")
    private String fio;

    /**
     * дата рождения
     */
    @Column( name = "date_of_birth")
    private Date dateOfBirth;

    /**
     * логин
     */
    @Column( name = "login")
    private String login;

    /**
     * пароль
     */
    @Column(name = "password")
    private String password;

    /**
     * номер телефона
     */
    @Column(name="phone_number")
    private String phoneNumber;

    /**
     * адресс
     */
    @Column(name = "address")
    private String address;

    /**
     * роль
     */
    @Column( name = "role")
    private String rule;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}