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
    @NotNull(message = " поле авто на складе не должно быть пустым")
    private AutoInStockDto autoInStock;

    /**
     * ссылка на соответствующий статус
     */
   // @NotNull(message = " поле статус не должно быть пустым")
    private DictOrderStatusDto dictOrderStatus;

    /**
     * ссылка на соответствующего пользователя
     */
   // @NotNull(message = " поле пользователь не должно быть пустым")
    private UsersDto users;

    /**
     * id
     */
    private Integer id;

    /**
     * цена заказа
     */
  //  @NotNull(message = " поле цена не должно быть пустым")
  //  @DecimalMin(value = "10.0", inclusive = true,message = "цена должна быть не меньше 10")
    private BigDecimal price;

  //  @NotNull(message = "поле номер заказа не должно быть пустым")
    private String orderNumber;

    /**
     * дата заказа
     */
  //  @NotNull(message = " поле дата не должно быть пустым")
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
