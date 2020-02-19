package ru.reksoft.interns.carstore.dto;



import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * цвет
 */
public class ColorDto {

    /**
     * id
     */
    private Integer id;

    /**
     * название цвета
     */
    @NotBlank(message = "размер от 4 до 20")
    @Size(min = 4,max=20,message = "название цвета должно быть от 4 до 20 символов")
    private String name;

    /**
     * цена за цвет
     */
    @DecimalMin(value = "10.0", inclusive = true,message = "цена должна быть не меньше 10")
    @NotNull(message = " поле цена не должно быть пустым")
    private BigDecimal price;

    /**
     * цветовой код HEX
     */
//    @Pattern(regexp = "#([0-9a-f]{3}|[0-9a-f]{6}|[0-9a-f]{8})"
//            ,message = "код цвета должен быть в формате HEX")
    private String colorCode;

    /**
     * наличие
     */
    //private Boolean removed;

    public ColorDto(){}

    public ColorDto(String name, BigDecimal price, String colorCode) {
        this.name=name;
        this.price=price;
        this.colorCode=colorCode;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

//    public Boolean getRemoved() {
//        return removed;
//    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setRemoved(Boolean removed) {
//        this.removed = removed;
//    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
}