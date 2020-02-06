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
    @NotBlank(message = " поле имя не должно быть пустым")
    @Size(min = 4,max=20,message = "название должно содержать от 4 до 20 символов")
    private String name;

    /**
     * цена за двигатель
     */
    @DecimalMin(value = "10.0", inclusive = true,message = "цена должна быть не мееньше 10")
    @NotNull(message = " поле цена не должно быть пустым")
    private BigDecimal price;

    /**
     * наличие
     */
    private boolean removed;

    /**
     * мощность
     */
    @NotNull(message = " поле мощность не должно быть пустым")
    private Integer power;

    /**
     * расход топлива
     */
    @NotNull(message = " поле расход топлива не должно быть пустым")
    private Integer fuelConsumption;

    /**
     * ссылка на соответствующую модель
     */
    @NotNull(message = " поле модель не должно быть пустым")
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

    public boolean getRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
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
