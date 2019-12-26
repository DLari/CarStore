package ru.reksoft.interns.carstore.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * двигатель
 */
@Entity
@Table( name="engine")
public class Engine {

    /**
     * связь с таблицей модель
     */
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Integer id;

    /**
     * /название двигателя
     */
    @Column( name = "name")
    private String name;

    /**
     * цена
     */
    @Column( name = "price")
    private BigDecimal price;

    /**
     * наличие
     */
    @Column(name = "removed")
    private Boolean removed;

    /**
     * мощность
     */
    @Column( name = "power")
    private Integer power;

    /**
     * расход топлива
     */
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