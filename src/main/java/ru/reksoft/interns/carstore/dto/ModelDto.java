package ru.reksoft.interns.carstore.dto;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * модель
 */
public class ModelDto {

    /**
     * id
     */
    private Integer id;

    /**
     * название модели
     */
    @NotBlank
    @Size(min=2, max=50)
    private String name;

    /**
     * цена модели
     */
    @DecimalMin(value = "10.0", inclusive = true,message = "цена должна быть не мееньше 10")
    @NotNull
    private BigDecimal price;

    /**
     * ширина модели
     */
    @NotBlank(message = " поле ширина модели не должно быть пустым")
    private String widthCarcass;

    /**
     * длина модели
     */
    @NotBlank(message = " поле длина модели не должно быть пустым")
    private String lenghtCarcass;

    /**
     * наличие
     */
    private boolean removed;

    /**
     * ссылка на соответствующий кузов
     */
    @NotNull(message = " поле каркас не должно быть пустым")
    private DictCarcassDto dictCarcass;

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

    public boolean getRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public DictCarcassDto getDictCarcass() {
        return dictCarcass;
    }

    public void setDictCarcass(DictCarcassDto dictCarcass) {
        this.dictCarcass = dictCarcass;
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
    }}
