package ru.reksoft.interns.carstore.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
@Table( name="engine")
public class Engine {

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Integer id;

    @Column( name = "name")
    private String name;

    @Column( name = "price")
    private BigDecimal price;

    @Column(name = "removed")
    private Boolean removed;

    @Column( name = "power")
    private Integer power;

    @Column(name = "fuel_сonsumption")
    private Integer fuelConsumption;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Integer fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}