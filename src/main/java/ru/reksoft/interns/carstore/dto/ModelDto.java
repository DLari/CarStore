package ru.reksoft.interns.carstore.dto;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    @DecimalMin(value = "10.0", inclusive = true)
    private BigDecimal price;

    /**
     * ширина модели
     */
    @NotBlank
    private String widthCarcass;

    /**
     * длина модели
     */
    @NotBlank
    private String lenghtCarcass;

    /**
     * наличие
     */
    private Boolean removed;

    /**
     * ссылка на соответствующий кузов
     */
    @NotBlank
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

    public Boolean getRemoved() {
        return removed;
    }

    public void setRemoved(Boolean removed) {
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
