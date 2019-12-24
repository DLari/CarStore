package ru.reksoft.interns.carstore.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
//@Setter
//@Getter
@Table(name="color")
public class Color {

 /*@OneToMany(mappedBy = "color")
    private List<AutoInStock> autoInStocks;*/

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
    private Integer id;


    @Column( name = "name")
    private String name;

   // @Positive

    @Column(name = "price")
    private BigDecimal price;


    @Column(name = "removed")
    private Boolean removed;

//    Color(String name, BigDecimal price, Boolean removed) {
//        //this.id-id;
//        this.name=name;
//        this.price=price;
//        this.removed=removed;
//    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }
}