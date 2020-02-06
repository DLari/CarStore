package ru.reksoft.interns.carstore.dto;


import javax.validation.constraints.*;
import java.sql.Date;

/**
 * пользователи
 */
public class UsersDto {

    /**
     * id
     */
    private Integer id;

    /**
     * фио
     */
    @NotBlank
    @Size(min = 5,max = 40,message = "ФИО должно содержать от 5 до 40 букв")
    private String fio;

    /**
     * дата рождения
     */
   // @NotNull(message = " поле дата не должно быть пустым")
    private Date dateOfBirth;

    /**
     * логин
     */
    @Pattern(regexp = "\\w{7,}",message = "Логин должен содержать не менее 7 символов")
    private String login;

    /**
     * пароль
     */
    @Pattern(regexp = "(?-i)(?=^.{8,}$)((?!.*\\s)(?=.*[A-Z])(?=.*[a-z]))((?=(.*\\d){1,})|(?=(.*\\W){1,}))^.*$"
            ,message = "пароль должен иметь не менее 8 символов, из которых не менее 1 заглавной, 1 сточной буквы и одного символа")
    private String password;

    /**
     * номер телефона
     */
    @NotBlank(message = "поле  номер телефона не должно быть пустым")
    private String phoneNumber;

    /**
     * адресс
     */
    @NotBlank(message = "поле адресс не должно быть пустым")
    private String address;

    /**
     * роль
     */
    @Null
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String rule) {
        this.role = rule;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
