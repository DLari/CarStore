package ru.reksoft.interns.carstore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Setter
@Getter
public class ModelDto {

    private Integer id;

    @NotBlank
    @Size(min=2, max=50)
    private String name;

    @NotBlank
    @DecimalMin(value = "10.0", inclusive = true)
    private BigDecimal price;

    @NotBlank
    private String widthCarcass;

    @NotBlank
    private String lenghtCarcass;


    private Boolean removed;

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
