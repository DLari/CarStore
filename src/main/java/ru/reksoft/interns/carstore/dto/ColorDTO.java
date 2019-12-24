package ru.reksoft.interns.carstore.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;
//@NoArgsConstructor
//@AllArgsConstructor
//@Data

//@Setter
//@Getter
@AllArgsConstructor
public class ColorDTO {

   // @NotNull(message = "не должно быть пустым")
    private Integer id;

    @NotBlank(message = "размер от 4 до 20")
    @Size(min = 4,max=20)
    private String name;

    @NotNull
    @DecimalMin(value = "10.0", inclusive = true)
   // @DecimalMax(value = "9.9", inclusive = true)
    private BigDecimal price;

    private Boolean removed;

//     ColorDTO(Integer id, String name, BigDecimal price, Boolean removed) {
//        this.id=id;
//        this.name=name;
//        this.price=price;
//        this.removed=removed;
//    }

//    public ColorDTO( String name, BigDecimal price) {
//        this.name=name;
//        this.price=price;
//    }

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