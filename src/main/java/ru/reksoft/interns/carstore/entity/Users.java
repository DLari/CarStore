package ru.reksoft.interns.carstore.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name="users")
public class Users {

    @OneToMany(mappedBy = "users")
    private List<Orders> orders;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fio")
    private String fio;

    @Column( name = "date_of_birth")
    private Date dateOfBirth;

    @Column( name = "login_client")
    private String login;

    @Column(name = "password_client")
    private String password;

    @Column( name = "rule")
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
}