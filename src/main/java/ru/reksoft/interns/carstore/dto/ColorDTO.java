package ru.reksoft.interns.carstore.dto;



import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * цвет
 */
public class ColorDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * название цвета
     */
    @NotBlank(message = "размер от 4 до 20")
    @Size(min = 4,max=20)
    private String name;

    /**
     * цена за цвет
     */
    @NotNull
    @DecimalMin(value = "10.0", inclusive = true)
    private BigDecimal price;

    /**
     * наличие
     */
    private Boolean removed;


    public Integer getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }
}