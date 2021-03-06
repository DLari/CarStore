package ru.reksoft.interns.carstore.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * авто на складе
 */
public class AutoInStockDto {

    /**
     * id
     */
    private Integer id;

    /**
     * количество доступных авто
     */
    @NotNull(message = " поле наличие не должно быть пустым")
    private Integer presence;

    /**
     * ссылка на соответствующую модель
     */
    @NotNull(message = " поле модель не должно быть пустым")
    private ModelDto model;

    /**
     * ссылка на соответствующий цвет
     */
    @NotNull(message = " поле цвет не должно быть пустым")
    private ColorDto color;

    /**
     * ссылка на соответствующий двигатель
     */
    @NotNull(message = " поле двигатель не должно быть пустым")
    private EngineDto engine;

    private BigDecimal price;

    public AutoInStockDto(){}

    public AutoInStockDto(Integer id, EngineDto engine, ModelDto model, ColorDto color, Integer presence, BigDecimal price) {
        this.id = id;
        this.engine = engine;
        this.model = model;
        this.color = color;
        this.presence = presence;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public ColorDto getColor() {
        return color;
    }

    public void setColor(ColorDto color) {
        this.color = color;
    }

    public EngineDto getEngine() {
        return engine;
    }

    public void setEngine(EngineDto engine) {
        this.engine = engine;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}