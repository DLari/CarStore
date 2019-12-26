package ru.reksoft.interns.carstore.dto;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * двигатель
 */
public class EngineDto {

    /**
     * id
     */
    private Integer id;

    /**
     * назваие двигателя
     */
    @NotBlank
    @Size(min = 4,max=20)
    private String name;

    /**
     * цена за двигатель
     */
    @NotNull
    @DecimalMin(value = "10.0", inclusive = true)
    private BigDecimal price;

    /**
     * наличие
     */
    private Boolean removed;

    /**
     * мощность
     */
    @NotNull
    private Integer power;

    /**
     * расход топлива
     */
    @NotNull
    private Integer fuelConsumption;

    /**
     * ссылка на соответствующую модель
     */
    @NotNull
    private  ModelDto model;

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
//
    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }
}
