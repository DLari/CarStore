package ru.reksoft.interns.carstore.dto;



import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * заказ
 */
public class OrdersDto {

    /**
     * ссылка на соответствующий авто
     */
    @NotNull
    private AutoInStockDto autoInStock;

    /**
     * ссылка на соответствующий статус
     */
    @NotNull
    private DictOrderStatusDto dictOrderStatus;

    /**
     * ссылка на соответствующего пользователя
     */
    @NotNull
    private UsersDto users;

    /**
     * id
     */
    private Integer id;

    /**
     * цена заказа
     */
    @NotNull
    @DecimalMin(value = "10.0", inclusive = true)
    private BigDecimal price;

    /**
     * дата заказа
     */
    @Past
    private Date date;

    public AutoInStockDto getAutoInStock() {
        return autoInStock;
    }

    public void setAutoInStock(AutoInStockDto autoInStock) {
        this.autoInStock = autoInStock;
    }

    public DictOrderStatusDto getDictOrderStatus() {
        return dictOrderStatus;
    }

    public void setDictOrderStatus(DictOrderStatusDto dictOrderStatus) {
        this.dictOrderStatus = dictOrderStatus;
    }

    public UsersDto getUsers() {
        return users;
    }

    public void setUsers(UsersDto users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
