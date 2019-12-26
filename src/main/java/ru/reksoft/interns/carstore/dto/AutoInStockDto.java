package ru.reksoft.interns.carstore.dto;

import javax.validation.constraints.NotNull;

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
    @NotNull
    private Integer presence;

    /**
     * ссылка на соответствующую модель
     */
    @NotNull
    private ModelDto model;

    /**
     * ссылка на соответствующий цвет
     */
    @NotNull
    private ColorDTO color;

    /**
     * ссылка на соответствующий двигатель
     */
    @NotNull
    private EngineDto engine;

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

    public ColorDTO getColor() {
        return color;
    }

    public void setColor(ColorDTO color) {
        this.color = color;
    }

    public EngineDto getEngine() {
        return engine;
    }

    public void setEngine(EngineDto engine) {
        this.engine = engine;
    }
}