package ru.reksoft.interns.carstore.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

import java.util.List;


@Entity
@Setter
@Getter
@Table(name="model")
public class Model {

    @OneToMany(mappedBy = "model")
    private List<AutoInStock> autoInStocks;

    @ManyToOne
    @JoinColumn(name = "dict_carcass_id")
    private DictCarcass dictCarcass;

    @OneToMany(mappedBy = "model")
    private List<Engine> engines;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column( name = "width_carcass")
    private String widthCarcass;

    @Column(name = "length_carcass")
    private String lenghtCarcass;

    @Column( name = "removed")
    private Boolean removed;

    public List<AutoInStock> getAutoInStocks() {
        return autoInStocks;
    }

    public void setAutoInStocks(List<AutoInStock> autoInStocks) {
        this.autoInStocks = autoInStocks;
    }

    public DictCarcass getDictCarcass() {
        return dictCarcass;
    }

    public void setDictCarcass(DictCarcass dictCarcass) {
        this.dictCarcass = dictCarcass;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
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

    public String getWidthCarcass() {
        return widthCarcass;
    }

    public void setWidthCarcass(String widthCarcass) {
        this.widthCarcass = widthCarcass;
    }

    public String getLenghtCarcass() {
        return lenghtCarcass;
    }

    public void setLenghtCarcass(String lenghtCarcass) {
        this.lenghtCarcass = lenghtCarcass;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }
}