package ru.reksoft.interns.carstore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Setter
@Getter
public class AutoInStockDto {

    @NotNull
    private Integer id;

    @NotNull
    private Integer presence;

    @NotNull
    private ModelDto model;

    @NotNull
    private ColorDTO color;

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