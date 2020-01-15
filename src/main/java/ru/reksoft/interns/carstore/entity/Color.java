package ru.reksoft.interns.carstore.entity;


import javax.persistence.*;
import java.math.BigDecimal;

/**
 * цвет
 */
@Entity
@Table(name="color")
public class Color {
    /**
     * id
     */
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private Integer id;

    /**
     * название цвета
     */
    @Column( name = "name")
    private String name;

    /**
     * цена
      */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * цветовой код HEX
     */
    @Column(name = "color_code")
    private String colorCode;

    /**
     * наличие
     */
    @Column(name = "removed")
    private Boolean removed;


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

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
}